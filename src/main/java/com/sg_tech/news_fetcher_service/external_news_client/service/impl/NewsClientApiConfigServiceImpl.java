package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;
import com.sg_tech.news_fetcher_service.external_news_client.mapper.NewsClientConfigMapper;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsClientConfigService;

@Service
public class NewsClientApiConfigServiceImpl implements INewsClientConfigService {

    private final NewsClientApiConfig newsClientApiConfig;

    public NewsClientApiConfigServiceImpl(NewsClientApiConfig newsClientApiConfig) {
        this.newsClientApiConfig = newsClientApiConfig;
    }

    public NewsClientApiConfigDto getNewsClientApiConfig() {
       return NewsClientConfigMapper.mapToDto(newsClientApiConfig, new NewsClientApiConfigDto());
    }

}
