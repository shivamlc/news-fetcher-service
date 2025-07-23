package com.sg_tech.news_fetcher_service.external_news_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceDto {

    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
}
