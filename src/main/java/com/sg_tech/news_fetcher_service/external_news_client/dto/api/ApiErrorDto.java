package com.sg_tech.news_fetcher_service.external_news_client.dto.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorDto {
    private String apiPath;
    private Map<String,List<String>> errorMessages;
    private HttpStatus errorCode; 
    private LocalDateTime errorLocalDateTime;     
}
