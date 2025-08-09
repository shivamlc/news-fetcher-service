package com.sg_tech.news_fetcher_service.external_news_client.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO representing a news source obtained from the news client API.
 * This class is used to encapsulate the details of a news source.
 */
@Schema
(
    name = "NewsSource", 
    description = "Client model representing a news source obtained from the news client API."
)

@Data
@AllArgsConstructor
public class Source {

    @Schema
    (
        name = "id", 
        description = "Unique identifier for the news source.",
        example = "abc-news" // Example value for id
    )
    private String id;

    @Schema
    (
        name = "name", 
        description = "Name of the news source.",
        example = "ABC News" // Example value for name
    )
    private String name;

    @Schema
    (
        name = "description", 
        description = "Description of the news source.",
        example = "Latest news from ABC." // Example value for description
    )
    private String description;

    @Schema
    (
        name = "url", 
        description = "URL of the news source.",
        example = "https://abcnews.go.com" // Example value for url
    )
    private String url;

    @Schema
    (
        name = "category", 
        description = "Category of the news source.",
        example = "general" // Example value for category
    )
    private String category;

    @Schema
    (
        name = "language", 
        description = "Language of the news source.",
        example = "en" // Example value for language
    )
    private String language;

    @Schema
    (
        name = "country", 
        description = "Country of the news source.",
        example = "us" // Example value for country
    )
    private String country;
}
