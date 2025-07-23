package com.sg_tech.news_fetcher_service.external_news_client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfigDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.TopHeadlineRequestDto;

@Service
public class ExternalNewsFetchService {

    private final NewsClientApiConfigDto newsClientApiConfig;
    private final RestClient restClient;

    public ExternalNewsFetchService(NewsClientApiConfigDto newsClientApiConfig) {
        this.newsClientApiConfig = newsClientApiConfig;
        this.restClient = RestClient.builder()
                .defaultHeader("X-Api-Key", newsClientApiConfig.apiKey())
                .build();
    }

    private UriComponentsBuilder buildUriComponents(String baseUrl, String endpoint, TopHeadlineRequestDto requestDto) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromUriString(baseUrl)
        .pathSegment(endpoint);

        if (requestDto.getPageSize() != null) {
        uriComponentsBuilder.queryParam("pageSize", requestDto.getPageSize());
        }
        if (requestDto.getPage() != null) {
        uriComponentsBuilder.queryParam("page", requestDto.getPage());
        }

        if(requestDto.getQuery() != null && !requestDto.getQuery().isBlank()) {
        uriComponentsBuilder.queryParam("q", requestDto.getQuery());
        }

        if(requestDto.getSources() != null && !requestDto.getSources().isBlank()) {
        uriComponentsBuilder.queryParam("sources", requestDto.getSources());
        return uriComponentsBuilder;
        }

        if (requestDto.getCountry() != null && !requestDto.getCountry().isBlank()) {
        uriComponentsBuilder.queryParam("country", requestDto.getCountry());
        }
        if (requestDto.getCategory() != null && !requestDto.getCategory().isBlank()) {
        uriComponentsBuilder.queryParam("category", requestDto.getCategory());
        }


        return uriComponentsBuilder;
           
}

    public NewsResponseDto getTopHeadLines(TopHeadlineRequestDto requestDto) {

        String baseUrl = newsClientApiConfig.baseUrl();
        String endpoint = newsClientApiConfig.endpoint().get("top-headlines");
        UriComponentsBuilder uriBuilder = buildUriComponents(baseUrl, endpoint, requestDto);

        String url = uriBuilder.toUriString();

        System.out.println("Fetching top headlines from URL: " + url);

        var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(NewsResponseDto.class);

        System.out.println("Response Status: " + response.getStatus());
        System.out.println("Total Results: " + response.getTotalResults());
        System.out.println("Articles: " + response.getArticles().length);
        return response;

    }
}
