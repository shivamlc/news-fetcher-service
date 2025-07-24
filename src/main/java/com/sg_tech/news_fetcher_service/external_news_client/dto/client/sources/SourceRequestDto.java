package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceRequestDto {
    private String category;
    private String language;
    private String country;
}
