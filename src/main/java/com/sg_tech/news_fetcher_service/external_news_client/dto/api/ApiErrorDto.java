package com.sg_tech.news_fetcher_service.external_news_client.dto.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for API error responses.
 * This class is used to encapsulate error details returned by the API.
 */
@Schema
(
    name = "ApiErrorDto", 
    description = "Dto for API error responses, encapsulating error details returned by the API."
)
@Data
@AllArgsConstructor
public class ApiErrorDto {

    @Schema
    (
        name = "apiPath", 
        description = "Path of the API endpoint that caused the error.",
        example = "/api/v1/news" // Example value for apiPath
    )
    private String apiPath;

    @Schema
    (
        name = "errorMessages", 
        description = "Key-value pair of error type and list of errors.",
        example = "error: [error_description]" // Example value for errorMessage
    )
    private Map<String,List<String>> errorMessages;

    @Schema
    (
        name = "errorCode", 
        description = "HTTP status code representing the error."
    )
    private HttpStatus errorCode; 

    @Schema
    (
        name = "errorLocalDateTime", 
        description = "Date-time when the error occured.",
        example = "2023-01-01T00:00:00" // Example value for errorLocalDateTime
    )
    private LocalDateTime errorLocalDateTime;     
}
