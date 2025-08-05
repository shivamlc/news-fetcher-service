package com.sg_tech.news_fetcher_service.external_news_client.aspect.customAspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation created for logging controller method invocations.
 * This aspect will log the method name when a controller method is invoked.
 */
@Retention(RetentionPolicy.RUNTIME)// This annotation will be available at runtime
@Target({java.lang.annotation.ElementType.METHOD}) // This annotation can be applied to methods
public @interface CustomLogAspect { // creates a custom annotation for logging
    
}
