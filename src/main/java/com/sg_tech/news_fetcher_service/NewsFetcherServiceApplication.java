package com.sg_tech.news_fetcher_service;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.sg_tech.news_fetcher_service.external_news_client.config.NewsClientApiConfig;
import com.sg_tech.news_fetcher_service.external_news_client.service.IAllNewsArticlesService;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsClientConfigService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ITopHeadlinesService;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableConfigurationProperties(value = NewsClientApiConfig.class)
@OpenAPIDefinition(info = @Info(title = "News Fetcher Service API", version = "v1.0.0", description = "Rest API for fetching news articles from various news sources.", contact = @Contact(name = "Shivam Gaur", email = "shivamgaur4068@gmail.com", url = "https://github.com/shivamlc"), license = @License(name = "Apache License, Version 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")), externalDocs = @ExternalDocumentation(description = "This api is a wrapper around 'News API' and is used to fetch news articles from various sources.", url = "https://newsapi.org/docs"))
public class NewsFetcherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsFetcherServiceApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider getMCpTools(
			ITopHeadlinesService topHeadlinesServiceImpl,
			IAllNewsArticlesService allNewsServiceImpl,
			INewsClientConfigService newsClientApiConfigServiceImpl,
			ISourceService sourceServiceImpl) {
		return MethodToolCallbackProvider.builder().toolObjects(
				topHeadlinesServiceImpl,
				allNewsServiceImpl,
				newsClientApiConfigServiceImpl,
				sourceServiceImpl).build();

	}

}
