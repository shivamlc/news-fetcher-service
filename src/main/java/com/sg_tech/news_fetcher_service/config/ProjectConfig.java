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

// ProjetcConfig class - provides project level configs.
/*@Configuration:
 * Purpose: Marks a class as a source of Spring bean definitions.

Think of it as: “This class configures beans for the application context.”

Equivalent to: The old <beans> XML configuration.

@EnableAspectJAutoProxy
What is @EnableAspectJAutoProxy?

A Spring annotation that enables support for handling components marked with @Aspect (from org.aspectj.lang.annotation).

It tells Spring to look for @Aspect classes and create proxies around beans where pointcuts are matched.

Basically: “Turn on AOP proxying so aspects can intercept method calls.”
 */
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
