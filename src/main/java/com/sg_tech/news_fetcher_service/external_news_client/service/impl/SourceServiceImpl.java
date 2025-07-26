package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

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
    private UriComponentsBuilder buildUriComponents(String baseUrl, String endpoint, SourceRequest requestDto) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromUriString(baseUrl)
        .pathSegment(endpoint);


        if(requestDto.getLanguage() != null) {
        uriComponentsBuilder.queryParam("language", requestDto.getLanguage().getCode());
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
    public SourceResponse fetchSources(SourceRequest sourceRequestDto) {
        String baseUrl = newsClientApiConfig.baseUrl();
        String endpoint = newsClientApiConfig.endpoint().get("sources");
        UriComponentsBuilder uriBuilder = buildUriComponents(baseUrl, endpoint, sourceRequestDto);

        String url = uriBuilder.toUriString();

        System.out.println("Fetching sources from URL: " + url);

        var response = restClient.get()
                .uri(url)
                .retrieve()
                .body(SourceResponse.class);

        System.out.println("Response Status: " + response.getStatus());

        System.out.println("Sources: " + response.getSources().size());

        return response;
    }
}
