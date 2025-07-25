package com.sg_tech.news_fetcher_service.external_news_client.dto.client.allNews;

import java.time.LocalDateTime;
import java.util.List;

import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.SearchArea;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.SortBy;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllNewsRequestDto {

    @Max(value = 500, message = "Query size must be between 1 and 500")
    @NotBlank(message = "Query cannot be blank")
    private String query;

    // Optional attrs, can be null if not specified
    @Nullable
    private List<SearchArea> searchIn; 

    @Nullable
    private List<String> sources;  

    @Nullable
    private List<String> domains;

    @Nullable
    private List<String> excludeDomains;

    @Nullable
    private LocalDateTime fromDate;

    @Nullable
    private LocalDateTime toDate;

    @Nullable
    private SortBy sortBy;
    
    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */

    @Positive
    @Max(value = 500, message = "Page size must be between 1 and 500")
    @Nullable
    private Integer pageSize;
    
    @Nullable
    private Integer page;
}