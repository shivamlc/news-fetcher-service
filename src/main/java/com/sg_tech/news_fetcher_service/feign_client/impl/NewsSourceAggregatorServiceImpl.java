package com.sg_tech.news_fetcher_service.feign_client.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.internal.NewsSourceDto;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.mapper.NewsSourceMapper;
import com.sg_tech.news_fetcher_service.external_news_client.model.Source;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceResponse;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.feign_client.NewsAggregatorClient;
import com.sg_tech.news_fetcher_service.feign_client.service.INewsSourceAggregatorService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NewsSourceAggregatorServiceImpl implements INewsSourceAggregatorService {

    private final NewsAggregatorClient newsSourceAggregatorClient;
    private final ISourceService sourceServiceImpl;
    private final String REQUEST_SOURCE = "NewsFetcherService"; // This can be a constant or fetched from properties

    public NewsSourceAggregatorServiceImpl(
            NewsAggregatorClient newsSourceAggregatorClient,
            ISourceService sourceServiceImpl) {
        this.newsSourceAggregatorClient = newsSourceAggregatorClient;
        this.sourceServiceImpl = sourceServiceImpl;
    }

    @Override
    @Order(1)
    @Scheduled(fixedRate = 3600000) // Example: fetch news sources every 60 minutes
    public String saveNewsSources() {
        SourceRequest sourceRequest = SourceRequest.builder()
                .category(null) // Set category if needed
                .language(null) // Set language if needed
                .country(Country.us) // Set country if needed
                .build();
        log.info("\n\n==> Fetching news sources with request: {}", sourceRequest);
        SourceResponse response = sourceServiceImpl.fetchSources(sourceRequest);
        if (response == null || response.getSources() == null) {
            log.error("==> News client api returned with no response");
            return "No news sources received from news client to save.";
        }
        log.info("\n\n==> Received response from news client api: {}", response);

        List<Source> newsSources = response.getSources();
        List<NewsSourceDto> newsSourceDtos = new ArrayList<>();
        newsSources.forEach(newsSource -> {
            NewsSourceDto dto = NewsSourceMapper.mapToDto(newsSource);
            newsSourceDtos.add(dto);
        });
        if (newsSourceDtos.isEmpty()) {
            log.warn("==> No news sources found to save.");
        } else {
            log.info("==> Sending news sources to aggregator service: {}", newsSourceDtos);
            newsSourceAggregatorClient.saveNewsSources(newsSourceDtos, REQUEST_SOURCE);
        }
        return "Completed scheduled job to save news sources.";

    }

}
