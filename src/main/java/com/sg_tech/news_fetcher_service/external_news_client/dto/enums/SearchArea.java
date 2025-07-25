package com.sg_tech.news_fetcher_service.external_news_client.dto.enums;

public enum SearchArea {
    title("title"),
    description("description"),
    content("content");

    private final String value;

    SearchArea(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
