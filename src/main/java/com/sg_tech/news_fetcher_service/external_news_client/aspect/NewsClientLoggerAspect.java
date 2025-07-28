package com.sg_tech.news_fetcher_service.external_news_client.aspect;

import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewsClientLoggerAspect {
    // This aspect can be used to log the execution of methods in the NewsClient
    // You can define pointcuts and advice here to log method calls, parameters, and results

    private Logger logger = Logger.getLogger(NewsClientLoggerAspect.class.getName());

    @Around("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))")
    public Object logAroundNewsClientServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Executing method: " + joinPoint.getSignature().getName());
        try {
            Instant start = Instant.now();
            Object result = joinPoint.proceed();
            Instant end = Instant.now();
            logger.info("Method executed in: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
            logger.info("Method result: " + result);
            logger.info("Method executed successfully: " + joinPoint.getSignature().getName());
            return result;
        } catch (Throwable throwable) {
            logger.severe("Method execution failed: " + joinPoint.getSignature().getName());
            throw throwable;
        }
    }
}
        