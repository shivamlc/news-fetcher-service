package com.sg_tech.news_fetcher_service.external_news_client.dto.api;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto<T> {

    private HttpStatus status;
    private String message;
    private T data; // Generic type to hold any data structure
}
