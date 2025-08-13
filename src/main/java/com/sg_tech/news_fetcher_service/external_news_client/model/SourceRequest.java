package com.sg_tech.news_fetcher_service.external_news_client.model;


import com.sg_tech.news_fetcher_service.external_news_client.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Language;

import io.micrometer.common.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "NewsSourceRequest Model", description = "Client model for fetching news sources from the news client API.")
@Data
@AllArgsConstructor
public class SourceRequest {
    
    @Schema
    ( 
        name = "category", 
        description = "Category of news sources to be fetched from the news client API.",
        example = "business" // Example value for category
    )
    // Optional parameters for filtering sources
    @Nullable
    private Category category;

    @Schema
    ( 
        name = "language", 
        description = "Language of the news sources to be fetched from the news client API.",
        example = "en" // Example value for language
    )
    @Nullable
    private Language language;

    @Schema
    ( 
        name = "country", 
        description = "Country for which news sources are to be fetched from the news client API.",
        example = "us" // Example value for country
    )
    @Nullable
    private Country country;
}
