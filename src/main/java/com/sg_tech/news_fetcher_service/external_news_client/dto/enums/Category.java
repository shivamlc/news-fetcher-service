package com.sg_tech.news_fetcher_service.external_news_client.dto.enums;


public enum Category {
    business("business"),
    entertainment("entertainment"),
    general("general"),
    health("health"),
    science("science"),
    sports("sports"),
    technology("technology");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}