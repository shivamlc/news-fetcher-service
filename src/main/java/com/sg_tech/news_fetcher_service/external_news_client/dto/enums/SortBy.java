package com.sg_tech.news_fetcher_service.external_news_client.dto.enums;

public enum SortBy {
    relevancy("relevancy"),
    popularity("popularity"),
    publishedAt("publishedAt");

    private final String value;

    SortBy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
