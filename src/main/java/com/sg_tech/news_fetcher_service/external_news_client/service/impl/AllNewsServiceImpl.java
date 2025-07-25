package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.client.allNews.AllNewsRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.BaseNewsClient;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsArticlesService;

@Service("allNewsServiceImpl")
public class AllNewsServiceImpl extends BaseNewsClient implements INewsArticlesService<AllNewsRequestDto> {

    public AllNewsServiceImpl(NewsClientApiConfigDto newsClientApiConfig) {
        super(newsClientApiConfig);
    }

    //TODO: refactor this
    private UriComponentsBuilder buildUriComponents(String baseUrl, String endpoint, AllNewsRequestDto requestDto) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(baseUrl)
                .pathSegment(endpoint);

        if (requestDto.getPageSize() != null) {
            uriComponentsBuilder.queryParam("pageSize", requestDto.getPageSize());
        }
        if (requestDto.getPage() != null) {
            uriComponentsBuilder.queryParam("page", requestDto.getPage());
        }

        if (requestDto.getQuery() != null && !requestDto.getQuery().isBlank()) {
            uriComponentsBuilder.queryParam("q", requestDto.getQuery());
        }

        if (requestDto.getSources() != null && !requestDto.getSources().isEmpty()) {
            String sources = String.join(",", requestDto.getSources());
            uriComponentsBuilder.queryParam("sources", sources);
        }

        if (requestDto.getSources() != null && !requestDto.getDomains().isEmpty()) {
            String domains = String.join(",", requestDto.getDomains());
            uriComponentsBuilder.queryParam("domains", domains);
        }

        if (requestDto.getSources() != null && !requestDto.getExcludeDomains().isEmpty()) {
            String excludeDomains = String.join(",", requestDto.getExcludeDomains());
            uriComponentsBuilder.queryParam("excludeDomains", excludeDomains);
        }

        if (requestDto.getFromDate() != null) {

            uriComponentsBuilder.queryParam("from", requestDto.getFromDate());
        }

         if (requestDto.getToDate() != null) {

            uriComponentsBuilder.queryParam("to", requestDto.getToDate());
        }

         if (requestDto.getSortBy() != null) {

            uriComponentsBuilder.queryParam("sortBy", requestDto.getSortBy().getValue());
        }

        return uriComponentsBuilder;

    }

    @Override
    public NewsResponseDto getNewsArticles(AllNewsRequestDto newsRequestDto) {
        String baseUrl = newsClientApiConfig.baseUrl();
        String endpoint = newsClientApiConfig.endpoint().get("everything");
        UriComponentsBuilder uriBuilder = buildUriComponents(baseUrl, endpoint, newsRequestDto);

        String url = uriBuilder.toUriString();

        System.out.println("Fetching all news from URL: " + url);

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
