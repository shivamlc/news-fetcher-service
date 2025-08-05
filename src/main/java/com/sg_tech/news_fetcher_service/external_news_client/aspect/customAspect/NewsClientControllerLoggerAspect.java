package com.sg_tech.news_fetcher_service.external_news_client.aspect.customAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class NewsClientControllerLoggerAspect {

    /**
     * This advice logs the method name when a controller method is invoked.
     * It logs the method name.
     *
     * @param joinPoint The join point representing the method execution.
     */
    @Before("@annotation(com.sg_tech.news_fetcher_service.external_news_client.aspect.customAspect.CustomLogAspect)")
    public void checkTopHeadlinesRequestDto(JoinPoint joinPoint) {
        log.info("Hitting controller method: {} ", joinPoint.getSignature());
    }

}
