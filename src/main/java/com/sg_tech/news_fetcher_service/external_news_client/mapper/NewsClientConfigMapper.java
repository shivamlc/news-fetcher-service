package com.sg_tech.news_fetcher_service.external_news_client.mapper;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

public class NewsClientConfigMapper {


    public static NewsClientApiConfigDto mapToDto(NewsClientApiConfig newsClientApiConfig,  NewsClientApiConfigDto dto) {
        if (newsClientApiConfig == null) {
            return null;
        }
        
    
        dto.setBaseUrl(newsClientApiConfig.baseUrl());
        dto.setEndpoint(newsClientApiConfig.endpoint());
        
        return dto;
    }
    
}
