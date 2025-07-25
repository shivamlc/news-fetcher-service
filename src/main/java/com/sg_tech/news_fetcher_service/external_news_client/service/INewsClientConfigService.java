package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

public interface INewsClientConfigService {

    NewsClientApiConfigDto getNewsClientApiConfig();

}
