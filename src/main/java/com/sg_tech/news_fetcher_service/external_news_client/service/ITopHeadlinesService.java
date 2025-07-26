package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;
import com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest;

public interface ITopHeadlinesService {

    /**
     * Fetches  top headlines based on the provided request DTO.
     *
     * @param newsRequestDto The request DTO containing parameters for fetching news articles.
     * @return A NewsResponseDto containing the status, total results, and articles.
     */

    ClientNewsResponse getTopNewsHeadlines(TopHeadlinesRequest newsRequestDto);
}
