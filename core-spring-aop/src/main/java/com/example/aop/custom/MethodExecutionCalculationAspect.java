package com.example.aop.custom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * TODO: Search for multi return types and use the same annotation
 */
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(TrackTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("Time Taken by {} is {} ms", joinPoint, timeTaken);
        return obj;
    }
}
