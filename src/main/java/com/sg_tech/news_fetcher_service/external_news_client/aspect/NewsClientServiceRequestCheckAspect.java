package com.sg_tech.news_fetcher_service.external_news_client.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(1) // Ensure this aspect runs before others
public class NewsClientServiceRequestCheckAspect {

    /**
     * * This method checks the SourceRequest DTO for null values.
     * * @param joinPoint The join point representing the method execution.
     * 
     * @param sourceRequest The SourceRequest DTO to check.
     */
    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.SourceServiceImpl.*(..)) && args(.., sourceRequest)")
    public void checkSourceRequestDto(JoinPoint joinPoint,
            com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest sourceRequest) {
        if (sourceRequest == null) {
            throw new RuntimeException(
                    "sourceRequest param is not properly configured for " + joinPoint.getSignature());
        } else {
            log.info("sourceRequest param is properly configured for " + joinPoint.getSignature());
        }
    }

    /**
     * This method checks the AllNewsRequest DTO for null values.
     *
     * @param joinPoint      The join point representing the method execution.
     * @param allNewsRequest The AllNewsRequest DTO to check.
     */
    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.AllNewsServiceImpl.*(..)) && args(.., allNewsRequest)")
    public void checkAllNewsRequestDto(JoinPoint joinPoint,
            com.sg_tech.news_fetcher_service.external_news_client.model.AllNewsRequest allNewsRequest) {
        if (allNewsRequest == null) {
            throw new RuntimeException(
                    "allNewsRequest param is not properly configured for " + joinPoint.getSignature());
        } else {
            log.info("allNewsRequest param is properly configured for " + joinPoint.getSignature());
        }
    }

    /**
     * This method checks the TopHeadlinesRequest DTO for null values.
     *
     * @param joinPoint           The join point representing the method execution.
     * @param topHeadlinesRequest The TopHeadlinesRequest DTO to check.
     */
    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.TopHeadlinesServiceImpl.*(..)) && args(.., topHeadlinesRequest)")
    public void checkTopHeadlinesRequestDto(JoinPoint joinPoint,
            com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest topHeadlinesRequest) {
        if (topHeadlinesRequest == null) {
            throw new RuntimeException(
                    "topHeadlinesRequest param is not properly configured for " + joinPoint.getSignature());
        } else {
            log.info("topHeadlinesRequest param is properly configured for " + joinPoint.getSignature());
        }
    }
}
