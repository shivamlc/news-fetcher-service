package com.sg_tech.news_fetcher_service.external_news_client.dto.api;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Generic API response DTO to standardize the structure of API responses.
 * 
 * @param <T> The type of data contained in the response.
 */
@Schema
(
    name = "ApiResponse", 
    description = "Generic API response DTO to standardize the structure of API responses."
)
@Data
@AllArgsConstructor
public class ApiResponseDto<T> {

    @Schema
    (
        name = "status", 
        description = "HTTP status code of the response.",
        example = "200" // Example value for status
    )
    private HttpStatus status;

    @Schema
    (
        name = "message", 
        description = "Message providing additional information about the response.",
        example = "Request processed successfully" // Example value for message
    )
    private String message;

    @Schema
    (
        name = "data", 
        description = "Data contained in the response, can be any type.",
        example = "{ \"key\": \"value\" }" // Example value for data
        
    )
    private T data; // Generic type to hold any data structure
}
