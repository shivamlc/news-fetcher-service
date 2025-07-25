package com.sg_tech.news_fetcher_service.external_news_client.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiErrorDto;

@ControllerAdvice(basePackages = "com.sg_tech.news_fetcher_service.external_news_client.controller")
public class ExternslNewsClientExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        Map<String, List<String>> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorsList = ex.getBindingResult().getAllErrors();

        validationErrorsList.forEach((error) -> {
            String fieldfName = ((FieldError) error).getField();
            String validationMessage = error.getDefaultMessage();
            validationErrors.put(fieldfName, List.of(validationMessage));

        });
        ApiErrorDto errorResponse = new ApiErrorDto(
                request.getDescription(false),
                validationErrors,
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidConfigValueException.class)
    public ResponseEntity<ApiErrorDto> handleInvalidConfigValueException(InvalidConfigValueException ex,
            WebRequest request) {
        Map<String, List<String>> errors = new HashMap<>();
        errors.put("errors", List.of(ex.getMessage()));
        ApiErrorDto errorResponse = new ApiErrorDto(
                request.getDescription(false),
                errors,
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDto> handleAnyOtherException(Exception ex, WebRequest request) {
        Map<String, List<String>> errors = new HashMap<>();
        errors.put("errors", List.of(ex.getMessage()));
        ApiErrorDto errorResponse = new ApiErrorDto(
                request.getDescription(false),
                errors,
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
