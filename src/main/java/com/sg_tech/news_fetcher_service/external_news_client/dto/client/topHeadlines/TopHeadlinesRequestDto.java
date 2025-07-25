package com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines;

import java.util.List;

import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Country;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TopHeadlinesRequestDto {

    private Country country; // either of country or sources must be specified

    private Category category; // Optional, can be null if not specified

    @Max(value = 500, message = "Query size must be between 1 and 500")
    private String query; // Optional, can be null if not specified

    private List<String> sources; // Optional, can be null if not specified

    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */

    @Positive
    @Max(value = 100, message = "Page size cannot exceed 100")
    private Integer pageSize; // Optional, can be null if not specified

    @Positive
    private Integer page; // Optional, can be null if not specified
}
