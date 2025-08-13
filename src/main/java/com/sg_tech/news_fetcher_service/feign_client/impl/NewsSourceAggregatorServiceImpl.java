package com.sg_tech.news_fetcher_service.feign_client.impl;

import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.feign_client.NewsSourceAggregatorClient;
import com.sg_tech.news_fetcher_service.feign_client.service.INewsSourceAggregatorService;

@Service
public class NewsSourceAggregatorServiceImpl implements INewsSourceAggregatorService {

    private final NewsSourceAggregatorClient newsSourceAggregatorClient;

    public NewsSourceAggregatorServiceImpl(NewsSourceAggregatorClient newsSourceAggregatorClient) {
        this.newsSourceAggregatorClient = newsSourceAggregatorClient;
    }

    @Override
    public String saveNewsSources() {
        return "";
    }

}
