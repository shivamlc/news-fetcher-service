package com.sg_tech.news_fetcher_service.external_news_client.dto.client;


import com.sg_tech.news_fetcher_service.external_news_client.dto.client.article.ArticleDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema
(
    name = "NewsResponse", 
    description = "Response DTO for presenting news articles obtained from the news client API."
)
// TODO: Replace List<ArticleDto> with internal DTO for List<ArticleDto> to suit business needs.
@Data
@AllArgsConstructor
public class NewsResponseDto {

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

    @Schema
    (
        name = "articles", 
        description = "List of news articles obtained from the news client API.",
        example = "[{\"source\": {\"id\": \"abc-news\", \"name\": \"ABC News\"}, \"author\": \"John Doe\", \"title\": \"Breaking News\", \"description\": \"Latest updates on the news.\", \"url\": \"https://abcnews.go.com\", \"urlToImage\": \"https://abcnews.go.com/image.jpg\", \"publishedAt\": \"2023-12-31T12:00:00Z\", \"content\": \"Full content of the article.\"}]" // Example value for articles
    )
    private ArticleDto[] articles;
    
}
