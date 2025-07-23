package com.sg_tech.news_fetcher_service.external_news_client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllNewsRequestDto {
    private String query;
    private String sources;
    /*
     * If you use @ModelAttribute for query/form parameters, it is required to use wrapper types (Integer instead of int) for fields that may be missing or optional.
        Primitive types like int cannot be null, so if the parameter is not provided, Spring will fail to bind and throw an error.
     */
    private Integer pageSize;
    private Integer page;
}