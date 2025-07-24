package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceResponseDto {
    private String status;
    private SourceDto[] sources;
}

