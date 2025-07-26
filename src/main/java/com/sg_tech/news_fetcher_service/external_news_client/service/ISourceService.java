package com.sg_tech.news_fetcher_service.external_news_client.service;

import com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceResponse;

public interface ISourceService {


    /**
     * Fetches sources based on the provided category, language, and country.
     *
     * @param category the category of news sources
     * @param language the language of news sources
     * @param country  the country of news sources
     * @return a SourceResponseDto containing the status and an array of SourceDto objects
     */
    SourceResponse fetchSources(SourceRequest sourceRequestDto);

}
