package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.model.ClientNewsResponse;
import com.sg_tech.news_fetcher_service.external_news_client.model.TopHeadlinesRequest;
import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.service.BaseNewsClient;
import com.sg_tech.news_fetcher_service.external_news_client.service.ITopHeadlinesService;

@Service("topHeadlinesServiceImpl")
public class TopHeadlinesServiceImpl extends BaseNewsClient implements ITopHeadlinesService {

    public TopHeadlinesServiceImpl(NewsClientApiConfig newsClientApiConfig) {
        super(newsClientApiConfig);
    }

    //TODO: refactor this
    private UriComponentsBuilder buildUriComponents(TopHeadlinesRequest topHeadlinesRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromUriString(newsClientApiConfig.baseUrl())
        .pathSegment(newsClientApiConfig.endpoint().get("top-headlines"));

        if (topHeadlinesRequest.getPageSize() != null) {
        uriComponentsBuilder.queryParam("pageSize", topHeadlinesRequest.getPageSize());
        }
        if (topHeadlinesRequest.getPage() != null) {
        uriComponentsBuilder.queryParam("page", topHeadlinesRequest.getPage());
        }

        if(topHeadlinesRequest.getQuery() != null && !topHeadlinesRequest.getQuery().isBlank()) {
        uriComponentsBuilder.queryParam("q", topHeadlinesRequest.getQuery());
        }

        if(topHeadlinesRequest.getSources() != null && !topHeadlinesRequest.getSources().isEmpty()) {
        String sources = String.join(",", topHeadlinesRequest.getSources());
        uriComponentsBuilder.queryParam("sources", sources);
        return uriComponentsBuilder;
        }

        if (topHeadlinesRequest.getCountry() != null) {
        uriComponentsBuilder.queryParam("country", topHeadlinesRequest.getCountry().getCode());
        }
        if (topHeadlinesRequest.getCategory() != null) {
        uriComponentsBuilder.queryParam("category", topHeadlinesRequest.getCategory().getValue());
        }

        return uriComponentsBuilder;       
}
@Tool(
        name = "fetch top headlines using country, language, and category or news sources",
        description = "Fetches top headlines based on the provided request parameters in TopHeadlinesRequest. " +
                      "This method constructs the request URL, sends the request to the external news API, " +
                      "and returns the response containing the top headlines."
    )

    /**
     * Fetches top headlines based on the provided request parameters in TopHeadlinesRequest.
     * This method constructs the request URL, sends the request to the external news API,
     * and returns the response containing the top headlines.
     *
     * @param newstopHeadlinesRequest The request parameters for fetching top headlines.
     * @return ClientNewsResponse containing the list of top headlines.
     */
    @Override
    public ClientNewsResponse getTopNewsHeadlines(TopHeadlinesRequest newstopHeadlinesRequest) {
        UriComponentsBuilder uriBuilder = buildUriComponents(newstopHeadlinesRequest);

        String url = uriBuilder.toUriString();

        var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(ClientNewsResponse.class);
        return response;

    }
}
