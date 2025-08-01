package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiErrorDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses.NewsClientConfigApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.impl.NewsClientApiConfigServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag
(
    name = "Rest api for external news client (News API) configs ", 
    description = "Provides endpoint for fetching external news client API configuration details."
)
@RestController
/**
 * @RequestMapping(path = "/api/v1/external/news-client/api") dpecifies prefix
 *                      path for all endpoints in this controller.
 *                      This is same
 *                      as @RequestMapping("/api/v1/external/news-client/api")
 *                      or @RequestMapping(value =
 *                      "/api/v1/external/news-client/api")
 *                      They all set the same base path for the controller or
 *                      method. `value` and `path` are interchangeable
 *                      attributes for specifying the URL mapping.
 *                      `produces = {MediaType.APPLICATION_JSON_VALUE}`
 *                      indicates that the endpoints in this controller will
 *                      produce JSON responses.
 */
@RequestMapping(path = "/api/v1/external/news-client/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class NewsClientApiConfigController {

    private final NewsClientApiConfigServiceImpl newsClientApiConfigService;

    public NewsClientApiConfigController(NewsClientApiConfigServiceImpl newsClientApiConfigService) {
        this.newsClientApiConfigService = newsClientApiConfigService;
    }

    /**
     * This endpoint fetches the configuration information for the external news
     * client API.
     * It provides details like base URL, endpoints, etc.
     *
     * @return ResponseEntity containing NewsClientApiConfigDto with configuration
     *         details.
     */
    @Operation(summary = "Fetch External News Client API Config", description = "This endpoint fetches the configuration information for the external news client API. It provides details like base URL, endpoints, etc.")
    @ApiResponses
    (
        value = {
            @ApiResponse
            (
                responseCode = "200",
                description = "This indicates that configs were fetched successfully.",
                 content = @Content
                (
                    
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = NewsClientConfigApiResponseDto.class)
                )
            ),
            @ApiResponse
            (
                responseCode = "400", 
                description = "Bad Request - Invalid request parameters.",
                content = @Content
                (
                    
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiErrorDto.class)
                )
            ),
            @ApiResponse
            (
                responseCode = "500", 
                description = "Internal Server Error - An unexpected error occurred.",
                content = @Content
                (
                    
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiErrorDto.class)
                )
            )
        }
    )

    @GetMapping("/config-info")
    public ResponseEntity<NewsClientConfigApiResponseDto> getNewsClientConfigInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new NewsClientConfigApiResponseDto(HttpStatus.OK,
                        "External news api client config fetched successfully.",
                        newsClientApiConfigService.getNewsClientApiConfig()));
    }
}
