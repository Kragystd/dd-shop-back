package com.kragy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class logAop {

    @Around("execution(* com.kragy.service.impl.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String simpleName = joinPoint.getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("\033[34m" + "aop=======小飞棍来咯=============================================================================" + "\033[0m");
        log.info("{} {} 开始", simpleName, methodName);
        log.info("{} {} 参数: {}", simpleName, methodName, args);
        return joinPoint.proceed();
    }
}
