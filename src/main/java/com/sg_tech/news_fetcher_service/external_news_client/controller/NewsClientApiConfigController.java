package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfigDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/external/news-client")
public class NewsClientApiConfigController {

    private final NewsClientApiConfigDto newsClientApiConfig;

    public NewsClientApiConfigController(NewsClientApiConfigDto newsClientApiConfig) {
        this.newsClientApiConfig = newsClientApiConfig;
    }

    @GetMapping("/api-config-info")
    public ResponseEntity<NewsClientApiConfigDto> getNewsClientConfigInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.newsClientApiConfig);
    }
}
