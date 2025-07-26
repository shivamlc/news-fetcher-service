package com.sg_tech.news_fetcher_service.external_news_client.model;

import java.util.List;

import com.sg_tech.news_fetcher_service.external_news_client.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "TopHeadlinesRequest", description = "Client model for fetching top headlines from the news client API.")
@Data
@AllArgsConstructor
public class TopHeadlinesRequest {

    @Schema
    ( 
        name = "country", 
        description = "Country for which top headlines are to be fetched from the news client API. Either country or sources must be specified.",
        example = "us" // Example value for country
    )
    @Nullable
    private Country country; // either of country or sources must be specified

    @Schema
    (
        name = "category", 
        description = "Category of news to filter the top headlines. Optional, can be null if not specified.",
        example = "business" // Example value for category
    )
    @Nullable
    private Category category; // Optional, can be null if not specified

    @Schema
    (
        name = "query", 
        description = "Query string to search for specific keywords in the top headlines. Optional, can be null if not specified.",
        example = "technology" // Example value for query
    )
    @Nullable
    @Size (min=0, max = 500, message = "Query size must be between 1 and 500")
    private String query; // Optional, can be null if not specified

   @ArraySchema
    (
        schema = @Schema(implementation = String.class),
        arraySchema = @Schema(
            description = "List of sources to filter the top headlines. Optional, can be null if not specified.",
            example = "[\"cnn\", \"bbc-news\"]"
        )
    )
    @Nullable
    private List<String> sources; // Optional, can be null if not specified

    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use
     * wrapper types (Integer instead of int) for fields that may be missing or
     * optional.
     * Primitive types like int cannot be null, so if the parameter is not provided,
     * Spring will fail to bind and throw an error.
     */

    @Schema
    (
        name = "pageSize", 
        description = "Number of results to return per page. Optional, can be null if not specified.",
        example = "20" // Example value for pageSize
    )
    @Positive
    @Max(value = 100, message = "Page size cannot exceed 100")
    @Nullable
    private Integer pageSize; // Optional, can be null if not specified

    @Schema
    (
        name = "page", 
        description = "Page number for pagination. Optional, can be null if not specified.",
        example = "1" // Example value for page
    )
    @Positive
    @Nullable
    private Integer page; // Optional, can be null if not specified
}
