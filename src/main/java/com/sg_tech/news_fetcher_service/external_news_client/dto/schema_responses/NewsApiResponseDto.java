package com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses;

import org.springframework.http.HttpStatus;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
(
    name = "NewsApiResponseDto",
    description = "Response containing a NewsResponseDto wrapped in ApiResponseDto"
)
public class NewsApiResponseDto extends ApiResponseDto<ClientNewsResponse> {
    public NewsApiResponseDto(HttpStatus status, String message, ClientNewsResponse data) {
        super(status, message, data);
    }
}