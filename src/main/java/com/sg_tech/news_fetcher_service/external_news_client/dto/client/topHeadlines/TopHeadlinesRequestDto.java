package com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TopHeadlinesRequestDto {

    @NotNull(message = "Country cannot be null for fetching top headlines")
    private String country;

    private String category; // Optional, can be null if not specified

    private String query; // Optional, can be null if not specified

    private String sources; // Optional, can be null if not specified

    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */

    @Positive
    private Integer pageSize; // Optional, can be null if not specified

    @Positive
    private Integer page; // Optional, can be null if not specified
}
