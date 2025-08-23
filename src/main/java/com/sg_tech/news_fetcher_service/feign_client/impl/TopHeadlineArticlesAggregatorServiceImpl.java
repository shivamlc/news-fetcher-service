package com.sg_tech.news_fetcher_service.feign_client.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;
import com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest;
import com.sg_tech.news_fetcher_service.external_news_client.service.ITopHeadlinesService;
import com.sg_tech.news_fetcher_service.feign_client.NewsArticleAggregatorClient;
import com.sg_tech.news_fetcher_service.feign_client.service.INewsArticleAggregationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TopHeadlineArticlesAggregatorServiceImpl implements INewsArticleAggregationService {

    private final NewsArticleAggregatorClient newsArticleAggregatorClient;
    private final String REQUEST_SOURCE = "NewsFetcherService"; // This can be a constant or fetched from properties
    private final ITopHeadlinesService topHeadlinesService;

    public TopHeadlineArticlesAggregatorServiceImpl(
            NewsArticleAggregatorClient newsArticleAggregatorClient,
            ITopHeadlinesService topHeadlinesService) {
        this.newsArticleAggregatorClient = newsArticleAggregatorClient;
        this.topHeadlinesService = topHeadlinesService;
    }

    @Override
    @Scheduled(fixedRate = 60000) // Example: fetch top headlines every 60 seconds
    public String saveNewsArticles() {
        log.info("==> Fetching top headline articles from news client api");
        TopHeadlinesRequest topHeadlinesRequest = TopHeadlinesRequest.builder()
                .country(Country.au) // Set country if needed
                .build();
        log.info("==> Top headlines request: {}", topHeadlinesRequest);
        ClientNewsResponse response = topHeadlinesService.getTopNewsHeadlines(topHeadlinesRequest);
        log.info("==> Received response from news client api: {}", response);

        if (response != null && response.getArticles() != null) {
            newsArticleAggregatorClient.saveNewsArticle(response.getArticles(), REQUEST_SOURCE);
        }

        log.info("==> Saving top headline articles");
        // Implementation for saving top headline articles
        return "Top headline articles saved successfully.";
    }
}
