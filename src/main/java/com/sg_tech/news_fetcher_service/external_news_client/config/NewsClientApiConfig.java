package com.sg_tech.news_fetcher_service.external_news_client.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

// by default the fileds are final and cannot be changed
// record is a special type of class in Java that is used to create immutable data classes
// it automatically generates the constructor, getters, equals, hashCode, and toString methods
// records are a good choice for configuration classes as they provide a concise way to define immutable data

@ConfigurationProperties(prefix = "external-news-api")
public record NewsClientApiConfig(String baseUrl, Map<String, String> endpoints, String apiKey) {

    public NewsClientApiConfig {
        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalArgumentException("Base URL cannot be null or blank");
        }
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("API Key cannot be null or blank");
        }
    }
}
