package com.sg_tech.news_fetcher_service.external_news_client.dto.client.article;

import com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources.SourceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

//TODO: Create an internal DTO for ArticleDto to suit business needs and create a mapper to map from this dto to the internal DTO.
@Data
@AllArgsConstructor
public class ArticleDto {
    private SourceDto source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
