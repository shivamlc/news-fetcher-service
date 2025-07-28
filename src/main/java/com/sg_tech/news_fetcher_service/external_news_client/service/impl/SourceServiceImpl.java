package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.sg_tech.news_fetcher_service.external_news_client.model.SourceRequest;
import com.sg_tech.news_fetcher_service.external_news_client.model.SourceResponse;
import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.service.BaseNewsClient;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;

@Service("sourceServiceImpl")
public class SourceServiceImpl extends BaseNewsClient implements ISourceService {

    public SourceServiceImpl(NewsClientApiConfig newsClientApiConfig) {
        super(newsClientApiConfig);
    }

    //TODO: refactor this
    private UriComponentsBuilder buildUriComponents(SourceRequest sourceRequest) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromUriString(newsClientApiConfig.baseUrl())
        .pathSegment(newsClientApiConfig.endpoint().get("sources"));


        if(sourceRequest.getLanguage() != null) {
        uriComponentsBuilder.queryParam("language", sourceRequest.getLanguage().getCode());
        } 
        if (sourceRequest.getCountry() != null) {
        uriComponentsBuilder.queryParam("country", sourceRequest.getCountry().getCode());
        } 
        if (sourceRequest.getCategory() != null) {
        uriComponentsBuilder.queryParam("category", sourceRequest.getCategory().getValue());
        }

        return uriComponentsBuilder;
}

    @Tool(
        name = "fetch news sources using country, language, and category",
        description = "Fetches news sources based on the provided request parameters in SourceRequest. " +
                      "This method constructs the request URL, sends the request to the external news API, " +
                      "and returns the response containing the sources."
    )   
    /**
     * Fetches sources based on the provided request parameters in SourceRequest.
     * This method constructs the request URL, sends the request to the external news API,
     * and returns the response containing the sources.
     *
     * @param sourceRequest The request parameters for fetching sources.
     * @return SourceResponse containing the list of sources.
     */
    @Override
    public SourceResponse fetchSources(SourceRequest sourceRequest) {
        UriComponentsBuilder uriBuilder = buildUriComponents(sourceRequest);

        String url = uriBuilder.toUriString();

        var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(SourceResponse.class);

        return response;
    }
}
