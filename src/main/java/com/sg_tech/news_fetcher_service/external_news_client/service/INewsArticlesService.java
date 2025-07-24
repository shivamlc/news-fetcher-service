package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.NewsResponseDto;

public interface INewsArticlesService<T> {

    /**
     * Fetches news articles based on the provided request DTO.
     *
     * @param newsRequestDto The request DTO containing parameters for fetching news articles.
     * @return A NewsResponseDto containing the status, total results, and articles.
     */

    NewsResponseDto getNewsArticles(T newsRequestDto);
}
