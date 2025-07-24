package com.sg_tech.news_fetcher_service.external_news_client.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiErrorDto;

@ControllerAdvice(basePackages = "com.sg_tech.news_fetcher_service.external_news_client.controller")
public class ExternslNewsClientExceptionHandler {

    @ExceptionHandler(InvalidConfigValueException.class)
    public ResponseEntity<ApiErrorDto> handleInvalidConfigValueException(InvalidConfigValueException ex, WebRequest request) {
        ApiErrorDto errorResponse = new ApiErrorDto(
                request.getDescription(false),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDto> handleAnyOtherException(Exception ex, WebRequest request) {
        ApiErrorDto errorResponse = new ApiErrorDto(
                request.getDescription(false),
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
