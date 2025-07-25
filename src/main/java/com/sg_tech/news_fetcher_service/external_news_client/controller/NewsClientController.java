package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiErrorDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.allNews.AllNewsRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines.TopHeadlinesRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsArticlesService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.external_news_client.service.impl.SourceServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Tag
(
    name = "Rest api for fetching news articles and sources from external news client (News API)", 
    description = "Provides endpoints for fetching news sources, all news articles and top headlines."
)
@RestController
@RequestMapping(path = "/api/v1/external/news-client/api/fetch", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class NewsClientController {


    private final INewsArticlesService<AllNewsRequestDto> allNewsServiceImpl;
    private final INewsArticlesService<TopHeadlinesRequestDto> topHeadlinesServiceImpl;
    private final ISourceService sourceServiceImpl;

    public NewsClientController(
        INewsArticlesService<AllNewsRequestDto> allNewsServiceImpl, 
        INewsArticlesService<TopHeadlinesRequestDto> topHeadlinesServiceImpl, 
        ISourceService sourceService
        , SourceServiceImpl sourceServiceImpl) {
        this.allNewsServiceImpl = allNewsServiceImpl;
        this.topHeadlinesServiceImpl = topHeadlinesServiceImpl;
        this.sourceServiceImpl = sourceServiceImpl;
    }
    /**
     * This endpoint fetches top headlines based on the provided request parameters.
     * 
     * @param requestDto The request parameters for fetching top headlines.
     * @return A ResponseEntity containing the NewsResponseDto with the top headlines.
     */
    @Operation(summary = "Fetch Top Headlines", description = "This endpoint fetches top headlines based on the provided request parameters.")
    @ApiResponses
    (
        value = {
            @ApiResponse(responseCode = "200", description = "This indicates that top headlines fetched successfully."),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request parameters."),
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

    @GetMapping("/top-headlines")
    public ResponseEntity<NewsResponseDto> getTopHeadLines(@Valid @ModelAttribute TopHeadlinesRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(topHeadlinesServiceImpl.getNewsArticles(requestDto));
    }

    /**
     * This endpoint fetches all news articles based on the provided request parameters.
     * 
     * @param requestDto The request parameters for fetching all news articles.
     * @return A ResponseEntity containing the NewsResponseDto with all news articles.
     */
    @Operation(summary = "Fetch All News Articles", description = "This endpoint fetches all news articles based on the provided request parameters.")
    @ApiResponses
    (
        value = {
            @ApiResponse(responseCode = "200", description = "This indicates that top headlines fetched successfully."),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request parameters."),
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

    @GetMapping("/all-news")
    public ResponseEntity<NewsResponseDto> getAllNews(@Valid @ModelAttribute AllNewsRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(allNewsServiceImpl.getNewsArticles(requestDto));
    }
    /**
     * This endpoint fetches all news sources based on the provided request parameters.
     * 
     * @param requestDto The request parameters for fetching news sources.
     * @return A ResponseEntity containing the SourceResponseDto with all news sources.
     */
    @Operation(summary = "Fetch All News Sources", description = "This endpoint fetches all news sources based on the provided request parameters.")
        @ApiResponses
    (
        value = {
            @ApiResponse(responseCode = "200", description = "This indicates that top headlines fetched successfully."),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request parameters."),
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

    @GetMapping("/all-sources")
    public ResponseEntity<SourceResponseDto> getAllSources(@Valid @ModelAttribute SourceRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(sourceServiceImpl.fetchSources(requestDto));
    }
}