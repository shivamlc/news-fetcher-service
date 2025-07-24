package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceResponseDto;

public interface ISourceService {


    /**
     * Fetches sources based on the provided category, language, and country.
     *
     * @param category the category of news sources
     * @param language the language of news sources
     * @param country  the country of news sources
     * @return a SourceResponseDto containing the status and an array of SourceDto objects
     */
    SourceResponseDto fetchSources(SourceRequestDto sourceRequestDto);

}
