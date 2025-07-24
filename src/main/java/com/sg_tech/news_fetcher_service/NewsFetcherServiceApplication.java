package com.sg_tech.news_fetcher_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sg_tech.news_fetcher_service.external_news_client.dto.config.NewsClientApiConfigDto;

@SpringBootApplication
@EnableConfigurationProperties(value = NewsClientApiConfigDto.class)
public class NewsFetcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsFetcherServiceApplication.class, args);
	}

}
