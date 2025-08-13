package com.sg_tech.news_fetcher_service.external_news_client.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema
(
    name = "NewsSourceResponse Model", 
    description = "Client model for presenting news sources obtained from the news client API."
)

@Data
@AllArgsConstructor
public class SourceResponse {
    @Schema
    (
        name = "status", 
        description = "Status of the response from the news client API.",
        example = "ok" // Example value for status
    )
    private String status;

   @ArraySchema
    (
        schema = @Schema(implementation = Source.class),
        arraySchema = @Schema(
            description = "List of news sources obtained from the news client API.",
            example = "[{\"id\": \"abc-news\", \"name\": \"ABC News\", \"description\": \"Latest news from ABC.\", \"url\": \"https://abcnews.go.com\", \"category\": \"general\"}]"
        )
    )
    private List<Source> sources;
}

