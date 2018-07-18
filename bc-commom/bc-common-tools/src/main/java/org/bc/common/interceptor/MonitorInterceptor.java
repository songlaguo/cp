package org.bc.common.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Jalon
 * @Description:
 * @create 2018/05/25 - 11:31
 * @package com.ikang.saas.common.interceptor
 */
@Aspect
@Component
public class MonitorInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);

    @Pointcut("execution(* com.ikang.saas.*.persistence..*Mapper.*(..))")
    private void monitorSQL() {
    }

    /**
     * 打印sql执行时长
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("monitorSQL()")
    public Object doAround(final ProceedingJoinPoint pjp) throws Throwable {
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        final String methodName = signature.getMethod().getName(); // 获取被拦截的方法名
        final long begin = System.currentTimeMillis();
        final Object obj = pjp.proceed();
        final long end = System.currentTimeMillis();
        //if((end-begin)>10L){
            logger.info(methodName + " sql waste time is :" + (end - begin) + "ms");
        //}
        return obj;
    }


    @Pointcut("execution(* com.ikang.saas.*.ui.controller..*Controller.*(..))")
    private void monitorController() {
    }

    @Around("monitorController()")
    public Object aroundController(final ProceedingJoinPoint pjp) throws Throwable {
        final MethodSignature signature = (MethodSignature) pjp.getSignature();
        final String methodName = signature.getMethod().getName();
        final long begin = System.currentTimeMillis();
        final Object obj = pjp.proceed();
        final long end = System.currentTimeMillis();
        logger.info("Controller " + methodName + " " + Arrays.toString(pjp.getArgs()) + " waste time is :"
                + (end - begin) + "ms");
        return obj;
    }

}
