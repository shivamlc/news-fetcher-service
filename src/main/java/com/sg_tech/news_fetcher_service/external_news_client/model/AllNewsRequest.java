package com.sg_tech.news_fetcher_service.external_news_client.model;

import java.time.LocalDateTime;
import java.util.List;

import com.sg_tech.news_fetcher_service.external_news_client.enums.SearchArea;
import com.sg_tech.news_fetcher_service.external_news_client.enums.SortBy;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "AllNewsRequest", description = "Client model for fetching all news from the news client API.")
@Data
@AllArgsConstructor
public class AllNewsRequest {

    @Schema
    (
        name = "query", 
        description = "Query string to search for specific keywords in the news articles. Required field.",
        example = "technology" // Example value for query
    )
    @Size (min=1, max = 500, message = "Query size must be between 1 and 500")
    @NotBlank(message = "Query cannot be blank")
    private String query;

    @Schema
    (
        name = "searchIn", 
        description = "List of news article components to search the query in. Optional, can be null if not specified.",
        example = "[title, description]" // Example value for searchIn
    )
    // Optional attrs, can be null if not specified
    @Nullable
    private List<SearchArea> searchIn; 

    @Schema
    (
        name = "sources", 
        description = "List of news sources to filter the news articles. Optional, can be null if not specified.",
        example = "[cnn, bbc-news]" // Example value for sources
    )
    @Nullable
    private List<String> sources;  

    @Schema
    (
        name = "domains", 
        description = "List of domains to filter the news articles. Optional, can be null if not specified.",
        example = "[example.com, news.com]" // Example value for domains
    )
    @Nullable
    private List<String> domains;

    @Schema
    (
        name = "excludeDomains", 
        description = "List of domains to exclude from the news articles. Optional, can be null if not specified.",
        example = "[excluded.com, spam.com]" // Example value for excludeDomains
    )
    @Nullable
    private List<String> excludeDomains;

    @Schema
    (
        name = "fromDate", 
        description = "Start date and time to filter the news articles. Optional, can be null if not specified.",
        example = "2023-01-01T00:00:00" // Example value for fromDate
    )
    @Nullable
    private LocalDateTime fromDate;

    @Schema
    (
        name = "toDate", 
        description = "End date and time to filter the news articles. Optional, can be null if not specified.",
        example = "2023-12-31T23:59:59" // Example value for toDate
    )
    @Nullable
    private LocalDateTime toDate;

    @Schema
    (
        name = "sortBy", 
        description = "Sorting order for the news articles. Optional, can be null if not specified.",
        example = "relevancy" // Example value for sortBy
    )
    @Nullable
    private SortBy sortBy;
    
    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */

    @Schema
    (
        name = "pageSize", 
        description = "Number of results to return per page. Optional, can be null if not specified.",
        example = "20" // Example value for pageSize
    )
    @Positive
    @Max(value = 500, message = "Page size must be between 1 and 500")
    @Nullable
    private Integer pageSize;

    @Schema
    (
        name = "page", 
        description = "Page number for pagination. Optional, can be null if not specified.",
        example = "1" // Example value for page
    )
    @Nullable
    private Integer page;
}