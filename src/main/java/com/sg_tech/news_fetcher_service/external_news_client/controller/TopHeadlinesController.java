package com.sg_tech.news_fetcher_service.external_news_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg_tech.news_fetcher_service.external_news_client.dto.AllNewsRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.NewsResponseDto;
import com.sg_tech.news_fetcher_service.external_news_client.dto.TopHeadlineRequestDto;
import com.sg_tech.news_fetcher_service.external_news_client.service.ExternalNewsFetchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@RestController
@RequestMapping("/api/external/news-client/api/fetch")
public class TopHeadlinesController {

    private final ExternalNewsFetchService externalNewsFetchService;

    public TopHeadlinesController(ExternalNewsFetchService externalNewsFetchService) {
        this.externalNewsFetchService = externalNewsFetchService;
    }

    @GetMapping("/top-headlines")
    public ResponseEntity<NewsResponseDto> getTopHeadLines(@ModelAttribute TopHeadlineRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(externalNewsFetchService.getTopHeadLines(requestDto));
    }

    @GetMapping("/all-news")
    public ResponseEntity<NewsResponseDto> getAllNews(@ModelAttribute AllNewsRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(externalNewsFetchService.getAllNews(requestDto));
    }
}


//TODO:
// Add enum for country codes
// Add enum for categories
// Add validation for country and category parameters
// Implement error handling for external API calls
// Consider caching the results for frequently requested headlines
// Add unit tests for the controller and service methods
// Document the API endpoints using Swagger or OpenAPI
// Implement rate limiting to avoid hitting the external API too frequently
// Consider adding pagination support for the top headlines response
// Implement a fallback mechanism in case the external API is down or returns an error
// Add logging for better traceability of requests and responses
// Consider using a DTO for the request parameters to encapsulate them better
// Implement security measures to protect the API endpoints
// Add support for additional query parameters like language, sources, etc.
// Consider using a circuit breaker pattern to handle failures in the external API
// Implement a health check endpoint to monitor the status of the external news client service
// Add support for fetching headlines based on user preferences or saved searches
// Consider implementing a background job to periodically fetch and cache top headlines
// Add support for filtering headlines by date or time range
// Implement a feature to allow users to subscribe to specific categories or sources for notifications
// Consider adding a feature to allow users to save or bookmark specific headlines
// Implement a feature to allow users to share headlines on social media platforms
// Add support for fetching headlines in different languages based on user preferences
// Consider implementing a feature to allow users to search for specific headlines or articles
// Add support for fetching related articles or similar headlines based on user interests
// Implement a feature to allow users to provide feedback or report issues with specific headlines
// Consider adding a feature to allow users to customize the news feed based on their interests
// Implement a feature to allow users to view trending headlines or popular articles
// Add support for fetching headlines from multiple sources or aggregating news from different providers
// Consider implementing a feature to allow users to filter out specific sources or categories they are not interested in
// Implement a feature to allow users to view headlines in a chronological order or based on relevance
// Add support for fetching headlines based on user location or preferences
// Consider implementing a feature to allow users to set up alerts for specific keywords or topics in the news
// Implement a feature to allow users to view headlines in a list or grid format
// Add support for fetching headlines based on user-defined tags or labels
// Consider implementing a feature to allow users to view headlines in a dark mode or light mode based on their preferences
// Implement a feature to allow users to view headlines in a compact or expanded view
// Add support for fetching headlines based on user-defined filters or criteria
// Consider implementing a feature to allow users to view headlines in a personalized news feed based on their interests
// Implement a feature to allow users to view headlines in a chronological timeline format
// Add support for fetching headlines based on user-defined topics or subjects
// Consider implementing a feature to allow users to view headlines in a magazine-style layout
// Implement a feature to allow users to view headlines in a card format with images and summaries
// Add support for fetching headlines based on user-defined regions or areas of interest
// Consider implementing a feature to allow users to view headlines in a split-screen format with multiple sources