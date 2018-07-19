package org.bc.saas.common.interceptor;

import java.lang.reflect.Method;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.bc.saas.common.utils.StringUtils;
import org.bc.saas.common.vo.AppResult;
import org.bc.saas.common.vo.Constant;
import org.bc.saas.common.vo.LoginParm;
import org.bc.saas.common.vo.RedisKey;
import org.bc.saas.common.vo.ReturnWrapper;
import org.bc.saas.common.vo.UserSession;

/**
 * @author User: R&M www.rmworking.com/blog Date: 2017/8/20 Time: 17:01 ikang-enterprise-platform
 *         com.ikang.enterprise.core.interceptor
 */
@Aspect
@Component
// 只有在测试环境和正式环境才初始化
@Profile({ "test", "prod", "uat" })
@SuppressWarnings("unchecked")
public class LoginInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 定义拦截规则：拦截com.ikang.enterprise.core.controller包下面的所有类中，有@RequestMapping注解的方法。 不需要登录验证的方法 请加
	 * NoNeedToLogin 注解
	 */
	@Pointcut("execution(* org.bc.saas.*.*.controller..*(..)) "
			+ "&& @annotation(org.springframework.web.bind.annotation.RequestMapping) "
			+ "&& !@annotation(org.bc.saas.common.annotation.NoNeedToLogin)")
	void controllerMethodPointcut() {
	}

	/**
	 * 全局登录拦截器
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("controllerMethodPointcut()")
	public AppResult<Object> interceptor(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		// 获取被拦截的方法
		Method method = signature.getMethod();
		// 获取被拦截的方法名
		String methodName = method.getName();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		logger.info("请求开始，方法：{}   当前sessionId：{}", methodName, request.getSession().getId());
		// 判断是否登录
		if (!isLogin(request)) {
			return new ReturnWrapper<>().timeout(Constant.ACCESS_CODE.TIMEOUT.getName());
		}
		return (AppResult<Object>) pjp.proceed();
	}

	/**
	 * 判断是否已经登录
	 * @param request
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Constant.LOGIN_STATE);
		logger.info("session中的值：obj ---> {} ", obj);
		return obj != null;
	}

	@Pointcut("@annotation(org.bc.saas.common.annotation.UserLogin)")
	void controllerMethodLogin() {
	}

	/**
	 * 拦截登录
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("controllerMethodLogin()")
	public AppResult<UserSession> loginInterceptor(ProceedingJoinPoint pjp) throws Throwable {
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		// 验证码校验先去掉
//		AppResult<UserSession> appResult = loginInterceptorCommon(new UserSession(), pjp, null);
		 AppResult<UserSession> appResult = (AppResult<UserSession>) pjp.proceed();
		int flag = appResult.getCode();
		if (flag != Constant.ACCESS_CODE.SUCCESS.getCode()) {
			return appResult;
		}
		UserSession user = appResult.getResults();
		/*
		 * 登录成功后删除缓存的验证码
		 */
		stringRedisTemplate.opsForHash().delete(RedisKey.IMG_CODE.key, request.getSession().getId());
		// 将结果加入session
		request.getSession().setAttribute(Constant.LOGIN_STATE, user);
		response.setHeader("P3P", "CP=CAO PSA OUR");
		logger.info("登录结果是：{} ————> 当前sessionId：{}", appResult.getMessage(), request.getSession().getId());
		return appResult;
	}

	/**
	 * 校验验证码
	 * @param t
	 * @param pjp
	 * @param commCode 线上性能测试通用验证码
	 * @param <T>
	 * @return
	 * @throws Throwable
	 */
	private <T> AppResult<T> loginInterceptorCommon(T t, ProceedingJoinPoint pjp, String commCode) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		// 获取被拦截的方法
		Method method = signature.getMethod();
		// 获取被拦截的方法名
		String methodName = method.getName();
		HttpServletRequest request = getRequest();
		logger.info("登陆请求开始，方法：{} ，请求参数：{}", methodName, request.getParameterMap().toString());
		Object sessionCode = stringRedisTemplate.opsForHash().get(RedisKey.IMG_CODE.key, request.getSession().getId());
		if (StringUtils.isEmpty(sessionCode)) {
			return new ReturnWrapper<T>().failed("验证码有误！");
		}
		String code = "";
		if (pjp.getArgs().length > 0) {
			LoginParm loginParm = (LoginParm) pjp.getArgs()[0];
			code = loginParm.getCode();
		}
		if (commCode != null) {
			if (!Objects.equals(code, commCode) && !Objects.equals(code, sessionCode.toString())) {
				return new ReturnWrapper<T>().failed("验证码有误！");
			}
		} else if (!Objects.equals(code, sessionCode.toString())) {
			return new ReturnWrapper<T>().failed("验证码有误！");
		}
		return (AppResult<T>) pjp.proceed();
	}

	private HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	private HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}
}
