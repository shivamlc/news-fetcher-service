package com.sg_tech.news_fetcher_service.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.sg_tech.news_fetcher_service.external_news_client.model.Article;

@FeignClient("NEWS-AGGREGATOR-SERVICE-DEV") // name feign client must be same as name of eureka app client
public interface NewsArticleAggregatorClient {

    // abstract method that must match the endpoint in the aggregator service
    @PostMapping(value = "/api/news-articles/save", consumes = "application/json") // specify the endpoint name and content type it accepts
    public String saveNewsArticle(@RequestBody Article newsArticle,
            @RequestHeader("request-source") String requestSource);
}
