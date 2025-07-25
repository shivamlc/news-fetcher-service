package com.sg_tech.news_fetcher_service.external_news_client.dto.config;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Schema
(
    name = "NewsClientApiConfig", 
    description = "Configuration DTO for the News Client API, containing base URL and endpoint mappings."
)
@Data
public class NewsClientApiConfigDto {
    @Schema
    (
        name = "baseUrl", 
        description = "Base URL of the News Client API.",
        example = "https://newsapi.org/v2" // Example value for baseUrl
    )
    private String baseUrl;
    
    @Schema
    (
        name = "endpoint", 
        description = "Map of API endpoints with their respective paths.",
        example = "{ \"allNews\": \"/everything\", \"sources\": \"/sources\" }" // Example value for endpoint
    )
    private Map<String, String> endpoint;
}
