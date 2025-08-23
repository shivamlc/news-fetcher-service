package com.sg_tech.news_fetcher_service.feign_client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.internal.NewsSourceDto;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.mapper.NewsSourceMapper;
import com.sg_tech.news_fetcher_service.external_news_client.model.Source;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceResponse;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.feign_client.NewsSourceAggregatorClient;
import com.sg_tech.news_fetcher_service.feign_client.service.INewsSourceAggregatorService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NewsSourceAggregatorServiceImpl implements INewsSourceAggregatorService {

    private final NewsSourceAggregatorClient newsSourceAggregatorClient;
    private final ISourceService sourceServiceImpl;
    private final String REQUEST_SOURCE = "NewsFetcherService"; // This can be a constant or fetched from properties

    public NewsSourceAggregatorServiceImpl(
            NewsSourceAggregatorClient newsSourceAggregatorClient,
            ISourceService sourceServiceImpl) {
        this.newsSourceAggregatorClient = newsSourceAggregatorClient;
        this.sourceServiceImpl = sourceServiceImpl;
    }

    @Override
    @Scheduled(fixedRate = 86400000) // Example: fetch news sources every 24 hours
    public String saveNewsSources() {
        SourceRequest sourceRequest = SourceRequest.builder()
                .category(null) // Set category if needed
                .language(null) // Set language if needed
                .country(Country.au) // Set country if needed
                .build();
        log.info("\n\n==> Fetching news sources with request: {}", sourceRequest);
        SourceResponse response = sourceServiceImpl.fetchSources(sourceRequest);
        log.info("\n\n==> Received response from news client api: {}", response);
        if (response != null && response.getSources() != null) {

            List<Source> newsSources = response.getSources();
            List<NewsSourceDto> newsSourceDtos = new ArrayList<>();
            newsSources.forEach(newsSource -> {
                NewsSourceDto dto = NewsSourceMapper.mapToDto(newsSource);
                newsSourceDtos.add(dto);
            });
            log.info("==> Saving news sources to database: {}", newsSourceDtos);
            newsSourceAggregatorClient.saveNewsSources(newsSourceDtos, REQUEST_SOURCE);
            return "News sources saved successfully.";
        }
        return "";
    }

}
