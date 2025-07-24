package com.sg_tech.news_fetcher_service.external_news_client.dto.api;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorDto {
    private String apiPath;
    private String errorMessage;
    private HttpStatus errorCode; 
    private LocalDateTime errorLocalDateTime;     
}
