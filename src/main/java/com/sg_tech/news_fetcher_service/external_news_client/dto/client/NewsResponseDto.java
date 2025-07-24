package com.sg_tech.news_fetcher_service.external_news_client.dto.client;


import com.sg_tech.news_fetcher_service.external_news_client.dto.client.article.ArticleDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsResponseDto {

    private String status;
    private int totalResults;
    private ArticleDto[] articles;
    
}
