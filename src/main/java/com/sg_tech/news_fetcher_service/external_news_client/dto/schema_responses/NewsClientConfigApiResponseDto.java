package com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses;

import org.springframework.http.HttpStatus;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
(
    name = "NewsClientConfigApiResponseDto",
    description = "Response containing a NewsClientApiConfigDto wrapped in ApiResponseDto"
)
public class NewsClientConfigApiResponseDto extends ApiResponseDto<NewsClientApiConfigDto> {
    public NewsClientConfigApiResponseDto(HttpStatus status, String message, NewsClientApiConfigDto data) {
        super(status, message, data);
    }
}