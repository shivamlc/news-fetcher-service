package com.sg_tech.news_fetcher_service.external_news_client.aspect;

import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2) // Ensure this aspect runs after the NewsClientApiConfigCheckAspect
public class NewsClientServiceLoggerAspect {
    // This aspect can be used to log the execution of methods in the NewsClient
    // You can define pointcuts and advice here to log method calls, parameters, and results

    private Logger logger = Logger.getLogger(NewsClientServiceLoggerAspect.class.getName());

 /**
     * This advice logs the execution of methods in the service layer.
     * It logs the method name, parameters, execution time, and result.
     *
     * @param joinPoint The join point representing the method execution.
     * @return The result of the method execution.
     * @throws Throwable If an error occurs during method execution.
     */

    @Around("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))")
    public Object logAroundNewsClientServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Executing method: " + joinPoint.getSignature().getName());
        try {
            Instant start = Instant.now();
            Object argsObjects[] = joinPoint.getArgs();
            StringBuilder args = new StringBuilder();
            for (Object arg : argsObjects) {
                args.append(arg.toString()).append(", ");
            }
            logger.info("Method arguments: " + args.toString());
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
        