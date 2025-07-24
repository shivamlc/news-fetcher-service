package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    private final NewsClientApiConfigDto newsClientApiConfig;

    public NewsClientApiConfigController(NewsClientApiConfigDto newsClientApiConfig) {
        this.newsClientApiConfig = newsClientApiConfig;
    }

    /**
     * This endpoint returns the configuration information for the external news
     * client API.
     * It provides details like base URL, endpoints, and API key.
     *
     * @return ResponseEntity containing NewsClientApiConfigDto with configuration
     *         details.
     */

    @GetMapping("/config-info")
    public ResponseEntity<ApiResponseDto<NewsClientApiConfigDto>> getNewsClientConfigInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponseDto<NewsClientApiConfigDto>(HttpStatus.OK,
                        "External news api client config fetched successfully.",
                        newsClientApiConfig));
    }
}
