package com.sg_tech.news_fetcher_service.external_news_client.dto.config;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
public class NewsClientApiConfigDto {
    private String baseUrl;
    private Map<String, String> endpoint;
}
