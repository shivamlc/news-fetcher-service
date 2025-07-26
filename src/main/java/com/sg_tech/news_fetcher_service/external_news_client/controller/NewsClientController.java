package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.api.ApiErrorDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses.NewsApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.schema_responses.SourceApiResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.model.AllNewsRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest;
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


    // private final INewsArticlesService<AllNewsRequest> allNewsServiceImpl;
    private final INewsArticlesService<TopHeadlinesRequest> topHeadlinesServiceImpl;
    private final ISourceService sourceServiceImpl;

    public NewsClientController(
        // INewsArticlesService<AllNewsRequest> allNewsServiceImpl, 
        INewsArticlesService<TopHeadlinesRequest> topHeadlinesServiceImpl, 
        ISourceService sourceService
        , SourceServiceImpl sourceServiceImpl) {
        // this.allNewsServiceImpl = allNewsServiceImpl;
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
            @ApiResponse
            (
                responseCode = "200", 
                description = "This indicates that top headlines fetched successfully.",
                content = @Content
                (
                    
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = NewsApiResponseDto.class)
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

    @GetMapping("/top-headlines")
    public ResponseEntity<NewsApiResponseDto> getTopHeadLines(@Valid @ModelAttribute TopHeadlinesRequest requestDto) {
        NewsApiResponseDto response = new NewsApiResponseDto(
                HttpStatus.OK,
                "Top headlines fetched successfully.",
                topHeadlinesServiceImpl.getNewsArticles(requestDto));
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    // /**
    //  * This endpoint fetches all news articles based on the provided request parameters.
    //  * 
    //  * @param requestDto The request parameters for fetching all news articles.
    //  * @return A ResponseEntity containing the NewsResponseDto with all news articles.
    //  */
    // @Operation(summary = "Fetch All News Articles", description = "This endpoint fetches all news articles based on the provided request parameters.")
    // @ApiResponses
    // (
    //     value = {
    //         @ApiResponse
    //         (
    //             responseCode = "200",
    //             description = "This indicates that all news articles fetched successfully.",
    //             content = @Content
    //             (
                    
    //                 schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = NewsApiResponseDto.class)
    //             )
    //         ),
    //         @ApiResponse
    //         (
    //             responseCode = "400", 
    //             description = "Bad Request - Invalid request parameters.",
    //             content = @Content
    //             (
                    
    //                 schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiErrorDto.class)
    //             )
    //         ),
    //         @ApiResponse
    //         (
    //             responseCode = "500", 
    //             description = "Internal Server Error - An unexpected error occurred.",
    //             content = @Content
    //             (
                    
    //                 schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ApiErrorDto.class)
    //             )
    //         )
    //     }
    // )

    // @GetMapping("/all-news")
    // public ResponseEntity<NewsApiResponseDto> getAllNews(@Valid @ModelAttribute AllNewsRequest requestDto) {
    //     NewsApiResponseDto response = new NewsApiResponseDto(
    //             HttpStatus.OK,
    //             "All news articles fetched successfully.",
    //             allNewsServiceImpl.getNewsArticles(requestDto));
    //     return ResponseEntity.status(HttpStatus.OK)
    //             .body(response);
    // }
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
            @ApiResponse
            (
                responseCode = "200", 
                description = "This indicates that news sources were fetched successfully.",
                content = @Content
                (
                    
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SourceApiResponseDto.class)
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

    @GetMapping("/all-sources")
    public ResponseEntity<SourceApiResponseDto> getAllSources(@Valid @ModelAttribute SourceRequest requestDto) {
        SourceApiResponseDto response = new SourceApiResponseDto(
                HttpStatus.OK,
                "All news sources fetched successfully.",
                sourceServiceImpl.fetchSources(requestDto));
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}