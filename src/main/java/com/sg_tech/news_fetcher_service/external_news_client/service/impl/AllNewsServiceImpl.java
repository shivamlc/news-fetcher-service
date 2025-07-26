package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.model.AllNewsRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;
import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.service.BaseNewsClient;
import com.sg_tech.news_fetcher_service.external_news_client.service.IAllNewsArticlesService;

 @Service("allNewsServiceImpl")
public class AllNewsServiceImpl extends BaseNewsClient implements IAllNewsArticlesService {

    public AllNewsServiceImpl(NewsClientApiConfig newsClientApiConfig) {
        super(newsClientApiConfig);
    }

    //TODO: refactor this
    private UriComponentsBuilder buildUriComponents(String baseUrl, String endpoint, AllNewsRequest requestDto) {
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

    @Tool(
        name = "get all news articles using a query",
        description = "Fetches all news articles based on the provided request parameters in AllNewsRequest. " +
                      "This method constructs the request URL, sends the request to the external news API, " +
                      "and returns the response containing the news articles. " +
                      "The request has mandatory 'query' param can have optional parameters like 'sources', 'domains', 'excludeDomains', 'fromDate', 'toDate', and 'sortBy'. " +
                      "The response will contain the news articles based on the specified parameters."
    )

    /**
     * Fetches all news articles based on the provided request parameters in AllNewsRequest.
     * This method constructs the request URL, sends the request to the external news API,
     * and returns the response containing the news articles.
     *
     * @param newsRequestDto The request parameters for fetching all news articles.
     * @return ClientNewsResponse containing the list of all news articles.
     */
    @Override
    public ClientNewsResponse getNewsArticles(AllNewsRequest newsRequestDto) {
        String baseUrl = newsClientApiConfig.baseUrl();
        String endpoint = newsClientApiConfig.endpoint().get("everything");
        UriComponentsBuilder uriBuilder = buildUriComponents(baseUrl, endpoint, newsRequestDto);

        String url = uriBuilder.toUriString();

        System.out.println("Fetching all news from URL: " + url);

        var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(ClientNewsResponse.class);

        System.out.println("Response Status: " + response.getStatus());
        System.out.println("Total Results: " + response.getTotalResults());
        System.out.println("Articles: " + response.getArticles().length);
        return response;
    }

}
