package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.topHeadlines.TopHeadlinesRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.service.BaseNewsClient;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsArticlesService;

@Service("topHeadlinesServiceImpl")
public class TopHeadlinesServiceImpl extends BaseNewsClient implements INewsArticlesService<TopHeadlinesRequestDto> {

    public TopHeadlinesServiceImpl(NewsClientApiConfig newsClientApiConfig) {
        super(newsClientApiConfig);
    }

    //TODO: refactor this
    private UriComponentsBuilder buildUriComponents(String baseUrl, String endpoint, TopHeadlinesRequestDto requestDto) {
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

        if(requestDto.getSources() != null && !requestDto.getSources().isEmpty()) {
        String sources = String.join(",", requestDto.getSources());
        uriComponentsBuilder.queryParam("sources", sources);
        return uriComponentsBuilder;
        }

        if (requestDto.getCountry() != null) {
        uriComponentsBuilder.queryParam("country", requestDto.getCountry().getCode());
        }
        if (requestDto.getCategory() != null) {
        uriComponentsBuilder.queryParam("category", requestDto.getCategory().getValue());
        }

        return uriComponentsBuilder;       
}

    @Override
    public NewsResponseDto getNewsArticles(TopHeadlinesRequestDto newsRequestDto) {
        String baseUrl = newsClientApiConfig.baseUrl();
        String endpoint = newsClientApiConfig.endpoint().get("top-headlines");
        UriComponentsBuilder uriBuilder = buildUriComponents(baseUrl, endpoint, newsRequestDto);

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
