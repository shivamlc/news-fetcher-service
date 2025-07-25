package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema
(
    name = "NewsSourceResponse", 
    description = "Response DTO for presenting news sources obtained from the news client API."
)
// TODO: Replace List<SourceDto> with internal DTO for List<SourceDto> to suit business needs.
@Data
@AllArgsConstructor
public class SourceResponseDto {
    @Schema
    (
        name = "status", 
        description = "Status of the response from the news client API.",
        example = "ok" // Example value for status
    )
    private String status;

    @Schema
    (
        name = "sources", 
        description = "List of news sources obtained from the news client API.",
        example = "[{\"id\": \"abc-news\", \"name\": \"ABC News\", \"description\": \"Latest news from ABC.\", \"url\": \"https://abcnews.go.com\", \"category\": \"general\", \"language\": \"en\", \"country\": \"us\"}]" // Example value for sources
    )
    private List<SourceDto> sources;
}

