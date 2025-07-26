package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.model.AllNewsRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;

public interface IAllNewsArticlesService {

    /**
     * Fetches all news articles based on the provided request DTO.
     *
     * @param newsRequestDto The request DTO containing parameters for fetching news articles.
     * @return A NewsResponseDto containing the status, total results, and articles.
     */

    ClientNewsResponse getNewsArticles(AllNewsRequest newsRequestDto);
}
