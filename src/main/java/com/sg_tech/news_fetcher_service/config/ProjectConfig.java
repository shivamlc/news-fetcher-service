package com.sg_tech.news_fetcher_service.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.sg_tech.news_fetcher_service.external_news_client.service.IAllNewsArticlesService;
import com.sg_tech.news_fetcher_service.external_news_client.service.INewsClientConfigService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ISourceService;
import com.sg_tech.news_fetcher_service.external_news_client.service.ITopHeadlinesService;

@Configuration
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public ToolCallbackProvider getExternalClientApiMCpTools(
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
