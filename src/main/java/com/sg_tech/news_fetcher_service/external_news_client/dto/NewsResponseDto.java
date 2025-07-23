package com.sg_tech.news_fetcher_service.external_news_client.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsResponseDto {

    private String status;
    private int totalResults;
    private ArticleDto[] articles;
    
}
