package com.sg_tech.news_fetcher_service.external_news_client.dto.internal;

import com.sg_tech.news_fetcher_service.external_news_client.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Internal dto representing a news source obtained from the news client API.
 * This class is used to transfer news source data between services.
 */
@Schema
(
    name = "NewsSourceDto - Internal", 
    description = "Internal dto representing a news source obtained from the news client API. Used to transfer news source data between services"
)

@Data
@AllArgsConstructor
@Builder
public class NewsSourceDto {

    @Schema
    (
        name = "id", 
        description = "Unique identifier for the news source.",
        example = "abc-news" // Example value for id
    )
    @NotNull(message = "News source ID cannot be null")
    private String id;

    @Schema
    (
        name = "name", 
        description = "Name of the news source.",
        example = "ABC News" // Example value for name
    )
    @NotNull(message = "News source name cannot be null")
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
    private Category category;

    @Schema
    (
        name = "language", 
        description = "Language of the news source.",
        example = "en" // Example value for language
    )
    private Language language;

    @Schema
    (
        name = "country", 
        description = "Country of the news source.",
        example = "us" // Example value for country
    )
    private Country country;
}
