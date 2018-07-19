package org.bc.saas.common.interceptor;

import org.bc.saas.common.vo.AppResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * User: R&M www.rmworking.com/blog Date: 2017/8/23 Time: 09:54 ikang-enterprise-platform
 * com.ikang.enterprise.core.interceptor 通用异常拦截器
 */
@RestControllerAdvice
public class ExceptionInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public AppResult<Object> defaultErrorHandler(HttpServletRequest request, Exception e) {
		HttpStatus code = getStatus(request);
		logger.error("错误信息：{}", e.getLocalizedMessage());
		logger.error("错误信息：请求地址 {} 请求方式 {} 请求参数 {}", request.getRequestURI(), request.getMethod(),
				request.getQueryString());
		for (StackTraceElement ste : e.getStackTrace()) {
			// 在堆栈跟踪信息中，只打印本项目中类错误信息
			if (ste.getClassName().contains("com.ikang.saas") && !ste.getClassName().contains("$$")) {
				logger.error("错误信息：【{}】中的 方法【{}】第【{}】行 ，错误", ste.getClassName(), ste.getMethodName(),
						ste.getLineNumber());
			}
		}
		AppResult<Object> appResult = new AppResult<>();
		appResult.setCode(code.value());
		appResult.setErrors(code.name());
		appResult.setMessage(e.getLocalizedMessage());
		return appResult;
	}

	/**
	 * 获取错误编码
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
