package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

// TODO: Replace List<SourceDto> with internal DTO for List<SourceDto> to suit business needs.
@Data
@AllArgsConstructor
public class SourceResponseDto {
    private String status;
    private List<SourceDto> sources;
}

