package com.sg_tech.news_fetcher_service.external_news_client.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

@SpringBootTest
@EnableConfigurationProperties(NewsClientApiConfig.class)
@TestPropertySource(properties = {
    "external-news-api.base-url=https://newsapi.org",
    "external-news-api.api-key=test-key",
    "external-news-api.endpoint.topHeadlines=/v2/top-headlines",
    "external-news-api.endpoint.everything=/v2/everything",
    "external-news-api.endpoint.sources=/v2/sources"
})
public class NewsClientApiConfigServiceImplTest {


    @Autowired
    private NewsClientApiConfigServiceImpl newsClientApiConfigServiceImpl;

    @Test
    void givenNewsClientApiConfig_whenGetNewsClientApiConfigDto_thenDtoIsReturnedWithCorrectData() {
        // arrange
        // nothing to arrange

        //act
        NewsClientApiConfigDto newsClientApiConfigDto = this.newsClientApiConfigServiceImpl.getNewsClientApiConfig();

        // assert
        Assert.notNull(newsClientApiConfigDto, "News api client config dto cannot be null");
        Assert.notEmpty(List.of(newsClientApiConfigDto.getBaseUrl(), newsClientApiConfigDto.getEndpoint()), "News api client config dto must have non-empty base url and endpoint.");
        assertEquals("https://newsapi.org", newsClientApiConfigDto.getBaseUrl());
        assertEquals("/v2/top-headlines", newsClientApiConfigDto.getEndpoint().get("topHeadlines"));
        assertEquals("/v2/everything", newsClientApiConfigDto.getEndpoint().get("everything"));
        assertEquals("/v2/sources", newsClientApiConfigDto.getEndpoint().get("sources"));
    }
}