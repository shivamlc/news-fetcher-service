package com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses;

import org.springframework.http.HttpStatus;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceResponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
(
    name = "SourceApiResponseDto",
    description = "Response containing a SourceResponseDto wrapped in ApiResponseDto"
)
public class SourceApiResponseDto extends ApiResponseDto<SourceResponse> {
    public SourceApiResponseDto(HttpStatus status, String message, SourceResponse data) {
        super(status, message, data);
    }
}