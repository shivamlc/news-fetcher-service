package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;

import lombok.AllArgsConstructor;
import lombok.Data;

//TODO: Create an internal DTO for SourceDto to suit business needs and create a mapper to map from this dto to the internal DTO.
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
