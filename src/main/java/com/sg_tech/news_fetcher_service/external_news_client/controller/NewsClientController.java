package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.allNews.AllNewsRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines.TopHeadlinesRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsArticlesService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.external_news_client.service.impl.SourceServiceImpl;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



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

    @GetMapping("/top-headlines")
    public ResponseEntity<NewsResponseDto> getTopHeadLines(@Valid @ModelAttribute TopHeadlinesRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(topHeadlinesServiceImpl.getNewsArticles(requestDto));
    }

    @GetMapping("/all-news")
    public ResponseEntity<NewsResponseDto> getAllNews(@Valid @ModelAttribute AllNewsRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(allNewsServiceImpl.getNewsArticles(requestDto));
    }

    @GetMapping("/all-sources")
    public ResponseEntity<SourceResponseDto> getAllSources(@Valid @ModelAttribute SourceRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(sourceServiceImpl.fetchSources(requestDto));
    }
}