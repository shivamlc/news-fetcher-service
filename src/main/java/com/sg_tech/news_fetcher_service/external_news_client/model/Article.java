package com.sg_tech.news_fetcher_service.external_news_client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema
(
    name = "Article Model", 
    description = "Client model representing a news article obtained from the news client API."
)

@Data
@AllArgsConstructor
public class Article {
    @Schema
    (
        name = "source", 
        description = "Source of the news article.",
        example = "{\"id\": \"abc-news\", \"name\": \"ABC News\"}" // Example value for source
    )
    private Source source;

    @Schema
    (
        name = "author", 
        description = "Author of the news article.",
        example = "John Doe" // Example value for author
    )
    private String author;

    @Schema
    (
        name = "title", 
        description = "Title of the news article.",
        example = "Breaking News" // Example value for title
    )
    private String title;

    @Schema
    (
        name = "description", 
        description = "Description of the news article.",
        example = "Latest updates on the news." // Example value for description
    )
    private String description;

    @Schema
    (
        name = "url", 
        description = "URL of the news article.",
        example = "https://abcnews.go.com" // Example value for url
    )
    private String url;

    @Schema
    (
        name = "urlToImage", 
        description = "URL of the image associated with the news article.",
        example = "https://abcnews.go.com/image.jpg" // Example value for urlToImage
    )
    private String urlToImage;

    @Schema
    (
        name = "publishedAt", 
        description = "Publication date and time of the news article.",
        example = "2023-12-31T12:00:00Z" // Example value for publishedAt
    )
    private String publishedAt;

    @Schema
    (
        name = "content", 
        description = "Full content of the news article.",
        example = "Full content of the article." // Example value for content
    )
    private String content;
}
