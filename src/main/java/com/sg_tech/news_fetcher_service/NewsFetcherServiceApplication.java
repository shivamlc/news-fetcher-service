package com.sg_tech.news_fetcher_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(value = {NewsClientApiConfig.class})
@OpenAPIDefinition(info = @Info(title = "News Fetcher Service API", version = "v1.0.0", description = "Rest API for fetching news articles from various news sources.", contact = @Contact(name = "Shivam Gaur", email = "shivamgaur4068@gmail.com", url = "https://github.com/shivamlc"), license = @License(name = "Apache License, Version 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")), externalDocs = @ExternalDocumentation(description = "This api is a wrapper around 'News API' and is used to fetch news articles from various sources.", url = "https://newsapi.org/docs"))
public class NewsFetcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsFetcherServiceApplication.class, args);
	}
}
