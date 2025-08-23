package com.sg_tech.news_fetcher_service.feign_client.impl;

import java.util.ArrayList;
import java.util.List;

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

@Service
public class NewsSourceAggregatorServiceImpl implements INewsSourceAggregatorService {

    private final NewsSourceAggregatorClient newsSourceAggregatorClient;
    private final ISourceService sourceServiceImpl;

    public NewsSourceAggregatorServiceImpl
    (
     NewsSourceAggregatorClient newsSourceAggregatorClient,
     ISourceService sourceServiceImpl
     ) {
        this.newsSourceAggregatorClient = newsSourceAggregatorClient;
        this.sourceServiceImpl = sourceServiceImpl;
    }

    @Override
    @Scheduled(fixedRate = 60000) // Example: fetch news sources every 60 seconds
    public String saveNewsSources() {
        String requestSource = "NewsFetcherService"; // This can be a constant or fetched from properties
        SourceRequest sourceRequest = SourceRequest.builder()
                .category(null) // Set category if needed
                .language(null) // Set language if needed
                .country(Country.au) // Set country if needed
                .build();
        SourceResponse response = sourceServiceImpl.fetchSources(sourceRequest);
        if (response != null && response.getSources() != null) {
            
            List<Source> newsSources = response.getSources();
            List<NewsSourceDto> newsSourceDtos = new ArrayList<>();
            newsSources.forEach(newsSource -> {
                NewsSourceDto dto = NewsSourceMapper.mapToDto(newsSource);
                newsSourceDtos.add(dto);
            });
            newsSourceAggregatorClient.saveNewsSources(newsSourceDtos, requestSource);
            return "News sources saved successfully.";
        }
        return "";
    }

}
