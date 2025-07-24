package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.stereotype.Service;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;

@Service
public class SourceServiceImpl implements ISourceService {

    @Override
    public SourceResponseDto fetchSources(SourceRequestDto sourceRequestDto) {
        throw new UnsupportedOperationException("Unimplemented method 'fetchSources'");
    }
}
