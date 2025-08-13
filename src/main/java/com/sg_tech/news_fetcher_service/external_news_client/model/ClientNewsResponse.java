package com.sg_tech.news_fetcher_service.external_news_client.model;


import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema
(
    name = "Client News Response Model", 
    description = "Client model for presenting news articles obtained from the news client API."
)

@Data
@AllArgsConstructor
public class ClientNewsResponse {

    @Schema
    (
        name = "status", 
        description = "Status of the response from the news client API.",
        example = "ok" // Example value for status
    )
    private String status;

    @Schema
    (
        name = "totalResults", 
        description = "Total number of news results obtained from the query.",
        example = "100" // Example value for totalResults
    )
    private int totalResults;

   @ArraySchema
    (
        schema = @Schema(implementation = Article.class),
        arraySchema = @Schema(
            description = "List of news articles obtained from the news client API.",
            example = "[{\"source\": {\"id\": \"abc-news\", \"name\": \"ABC News\"}, \"author\": \"John Doe\", \"title\": \"Breaking News\", \"description\": \"Latest updates on the news.\", \"url\": \"https://abcnews.go.com\", \"urlToImage\": \"https://abcnews.go.com/image.jpg\", \"publishedAt\": \"2023-01-01T00:00:00Z\", \"content\": \"Full content of the article.\"}]"
        )
    )
    private Article[] articles;
    
}
