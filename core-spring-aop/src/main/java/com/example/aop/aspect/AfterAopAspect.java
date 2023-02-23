package com.example.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.JoinPoint;

@Aspect
@Configuration
public class AfterAopAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.aop.business.*.*(..))")
    public void selectAllMethods() {
    }

    @AfterReturning(value = "(selectAllMethods())", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @After(value = "(selectAllMethods())")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

    @AfterThrowing(value = "(selectAllMethods())", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        logger.error("ERROR OCCURRED!!!!!!, {}, {}", throwable.getMessage(), joinPoint);
    }


}
