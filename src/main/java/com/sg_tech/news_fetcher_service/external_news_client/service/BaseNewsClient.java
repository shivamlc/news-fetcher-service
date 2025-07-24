package com.sg_tech.news_fetcher_service.external_news_client.service;

import org.springframework.web.client.RestClient;

import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

public abstract class BaseNewsClient {

    protected final RestClient restClient;
    protected final NewsClientApiConfigDto newsClientApiConfig;

    public BaseNewsClient(NewsClientApiConfigDto newsClientApiConfig) {
        this.newsClientApiConfig = newsClientApiConfig;
        this.restClient = RestClient.builder()
                .defaultHeader("X-Api-Key", newsClientApiConfig.apiKey())
                .build();
    }

}
