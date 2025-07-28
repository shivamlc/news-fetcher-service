package com.sg_tech.news_fetcher_service.external_news_client.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Ensure this aspect runs before others
public class NewsClientServiceRequestCheckAspect {

    private final Logger logger = Logger.getLogger(NewsClientServiceRequestCheckAspect.class.getName());
    

    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.SourceServiceImpl.*(..)) && args(.., sourceRequest)")
    public void checkSourceRequestDto(JoinPoint joinPoint, com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest sourceRequest) {
        if(sourceRequest == null) {
            throw new RuntimeException("sourceRequest param is not properly configured for " + joinPoint.getSignature());
        } else{
            logger.info("sourceRequest param is properly configured for " + joinPoint.getSignature());
        }
    }

    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.AllNewsServiceImpl.*(..)) && args(.., allNewsRequest)")
    public void checkAllNewsRequestDto(JoinPoint joinPoint, com.sg_tech.news_fetcher_service.external_news_client.model.AllNewsRequest allNewsRequest) {
        if(allNewsRequest == null) {
            throw new RuntimeException("allNewsRequest param is not properly configured for " + joinPoint.getSignature());
        } else{
            logger.info("allNewsRequest param is properly configured for " + joinPoint.getSignature());
        }
    }

    @Before("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.TopHeadlinesServiceImpl.*(..)) && args(.., topHeadlinesRequest)")
    public void checkTopHeadlinesRequestDto(JoinPoint joinPoint, com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest topHeadlinesRequest) {
        if(topHeadlinesRequest == null) {
            throw new RuntimeException("topHeadlinesRequest param is not properly configured for " + joinPoint.getSignature());
        } else{
            logger.info("topHeadlinesRequest param is properly configured for " + joinPoint.getSignature());
        }
    }
}
