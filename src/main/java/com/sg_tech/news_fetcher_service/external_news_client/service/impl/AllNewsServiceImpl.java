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
    private UriComponentsBuilder buildUriComponents(AllNewsRequest allNewsRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(newsClientApiConfig.baseUrl())
                .pathSegment(newsClientApiConfig.endpoint().get("everything"));

        if (allNewsRequest.getPageSize() != null) {
            uriComponentsBuilder.queryParam("pageSize", allNewsRequest.getPageSize());
        }
        if (allNewsRequest.getPage() != null) {
            uriComponentsBuilder.queryParam("page", allNewsRequest.getPage());
        }

        if (allNewsRequest.getQuery() != null && !allNewsRequest.getQuery().isBlank()) {
            uriComponentsBuilder.queryParam("q", allNewsRequest.getQuery());
        }

        if (allNewsRequest.getSources() != null && !allNewsRequest.getSources().isEmpty()) {
            String sources = String.join(",", allNewsRequest.getSources());
            uriComponentsBuilder.queryParam("sources", sources);
        }

        if (allNewsRequest.getSources() != null && !allNewsRequest.getDomains().isEmpty()) {
            String domains = String.join(",", allNewsRequest.getDomains());
            uriComponentsBuilder.queryParam("domains", domains);
        }

        if (allNewsRequest.getSources() != null && !allNewsRequest.getExcludeDomains().isEmpty()) {
            String excludeDomains = String.join(",", allNewsRequest.getExcludeDomains());
            uriComponentsBuilder.queryParam("excludeDomains", excludeDomains);
        }

        if (allNewsRequest.getFromDate() != null) {

            uriComponentsBuilder.queryParam("from", allNewsRequest.getFromDate());
        }

         if (allNewsRequest.getToDate() != null) {

            uriComponentsBuilder.queryParam("to", allNewsRequest.getToDate());
        }

         if (allNewsRequest.getSortBy() != null) {

            uriComponentsBuilder.queryParam("sortBy", allNewsRequest.getSortBy().getValue());
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
     * @param allNewsRequest The request parameters for fetching all news articles.
     * @return ClientNewsResponse containing the list of all news articles.
     */
    @Override
    public ClientNewsResponse getNewsArticles(AllNewsRequest allNewsRequest) {
        UriComponentsBuilder uriBuilder = buildUriComponents(allNewsRequest);

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
