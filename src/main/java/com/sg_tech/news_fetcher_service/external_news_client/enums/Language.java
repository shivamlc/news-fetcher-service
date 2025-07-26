package com.sg_tech.news_fetcher_service.external_news_client.enums;

/**
 * Enum representing possible languages for filtering news sources/headlines.
 * Default is ALL (all languages).
 */

public enum Language {
    ar("ar"),
    de("de"),
    en("en"),
    es("es"),
    fr("fr"),
    he("he"),
    it("it"),
    nl("nl"),
    no("no"),
    pt("pt"),
    ru("ru"),
    sv("sv"),
    ud("ud"),
    zh("zh");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}