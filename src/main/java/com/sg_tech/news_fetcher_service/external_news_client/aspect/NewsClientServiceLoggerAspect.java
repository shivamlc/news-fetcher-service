package com.sg_tech.news_fetcher_service.external_news_client.aspect;

import java.time.Instant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Importing Lombok's logging annotation for cleaner logging
@Component
@Aspect
@Order(2) // Ensure this aspect runs after the NewsClientApiConfigCheckAspect
public class NewsClientServiceLoggerAspect {
    // This aspect can be used to log the execution of methods in the NewsClient
    // You can define pointcuts and advice here to log method calls, parameters, and results

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
        log.info("Executing method: " + joinPoint.getSignature().getName());
        try {
            Instant start = Instant.now();
            Object argsObjects[] = joinPoint.getArgs();
            StringBuilder args = new StringBuilder();
            for (Object arg : argsObjects) {
                args.append(arg.toString()).append(", ");
            }
            log.info("Method arguments: " + args.toString());
            Object result = joinPoint.proceed();
            Instant end = Instant.now();
            log.info("Method executed in: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
            log.info("Method result: " + result);
            log.info("Method executed successfully: " + joinPoint.getSignature().getName());
            return result;
        } catch (Throwable throwable) {
            log.error("Method execution failed: " + joinPoint.getSignature().getName());
            throw throwable;
        }
    }

    /**
     * This advice logs exceptions thrown by methods in the service layer.
     * It logs the method name and exception message.
     *
     * @param joinPoint The join point representing the method execution.
     * @param exception The exception thrown by the method.
     */
    @AfterThrowing(
        value = "execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))",
        throwing = "exception"
    )
    public void logException(JoinPoint joinPoint, Exception exception){
        log.error("Exception in method: " + joinPoint.getSignature().getName() + " with message: " + exception.getMessage());
        
    }

    /**
     * This advice logs a termination message after the method execution.
     * It logs the method name.
     *
     * @param joinPoint The join point representing the method execution.
     */
    @After(value = "execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))")
    public void logTerminationMessage(JoinPoint joinPoint){
        log.debug("Method terminated: {}", joinPoint.getSignature().getName());
        
    }

    /**
     * This advice logs a message after the method execution without exceptions.
     * It logs the method name.
     *
     * @param joinPoint The join point representing the method execution.
     */
    @AfterReturning(value = "execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))")
    public void logMethodReturnMessage(JoinPoint joinPoint){
        log.info("Method returned w/o exception: {}", joinPoint.getSignature().getName());
        
    }
}
        