package com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines;

import java.util.List;

import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Country;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TopHeadlinesRequestDto {

    @Nullable
    private Country country; // either of country or sources must be specified

    @Nullable
    private Category category; // Optional, can be null if not specified

    @Nullable
    private String query; // Optional, can be null if not specified

    @Nullable
    private List<String> sources; // Optional, can be null if not specified

    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */

    @Positive
    @Max(value = 100, message = "Page size cannot exceed 100")
    @Nullable
    private Integer pageSize; // Optional, can be null if not specified

    @Positive
    @Nullable
    private Integer page; // Optional, can be null if not specified
}
