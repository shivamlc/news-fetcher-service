
# News Fetcher Service

## Overview
This project is a Spring Boot REST API service that connects to external news APIs to fetch news sources, all news articles, and top headlines. It is designed to be modular, maintainable, and easily extensible, leveraging modern Java and Spring Boot best practices. The service is also integrated with Model Context Protocol (MCP) tools, enabling advanced LLM (Large Language Model) capabilities for intelligent news querying and summarization.

## Features
- Fetches news sources, all news, and top headlines from external APIs
- Uses DTOs and models for clean data transfer and domain logic
- Configuration-driven using Spring's `@ConfigurationProperties`
- Dependency injection for all services and configuration
- Global exception handling for robust error management
- Modular service and controller layers
- MCP integration for LLM-powered news search and summarization

## Architecture & Design Principles
- **Separation of Concerns:** Controllers, services, DTOs, models, and configuration are clearly separated.
- **Dependency Injection:** All dependencies are injected using Spring's `@Autowired` or constructor injection, promoting testability and loose coupling.
- **Configuration Properties:** External API endpoints, keys, and other settings are managed via `@ConfigurationProperties` classes, making the service environment-agnostic and easy to configure.
- **DTOs and Models:** Data Transfer Objects (DTOs) are used for API requests and responses, while domain models encapsulate business logic.
- **Global Exception Handler:** A `@ControllerAdvice` class handles exceptions across the application, providing consistent error responses.
- **Extensibility:** The service layer is designed for easy extension to support new endpoints or news providers.
- **MCP Integration:** The project uses MCP tools to enable LLM-powered features, such as semantic search, summarization, and intelligent filtering of news articles.

## Key Components
- **Configuration:**
  - `NewsClientApiConfig` manages all external API configuration using `@ConfigurationProperties`.
- **DTOs:**
  - Request and response DTOs (e.g., `AllNewsRequest`, `ClientNewsResponse`) ensure clean API contracts and validation.
- **Models:**
  - Domain models represent news articles, sources, and related entities.
- **Services:**
  - Service interfaces and implementations (e.g., `IAllNewsArticlesService`, `AllNewsServiceImpl`) encapsulate business logic and API integration.
- **Controllers:**
  - REST controllers expose endpoints for fetching news, sources, and headlines.
- **Exception Handling:**
  - A global exception handler provides uniform error responses and logging.
- **MCP Tools:**
  - MCP tools are used for advanced LLM features, such as natural language queries, summarization, and context-aware news retrieval.

## How It Works
1. **Configuration:**
   - All API endpoints, keys, and settings are defined in configuration files and loaded via `@ConfigurationProperties`.
2. **Dependency Injection:**
   - Services and configuration beans are injected where needed, ensuring loose coupling and testability.
3. **REST Endpoints:**
   - Controllers expose endpoints for news sources, all news, and top headlines.
4. **Service Layer:**
   - Service implementations handle API requests, build URIs, and process responses.
5. **DTOs and Models:**
   - DTOs are used for request/response payloads; models encapsulate business logic.
6. **Exception Handling:**
   - All exceptions are caught and handled globally, returning meaningful error messages.
7. **MCP Integration:**
   - MCP tools enable LLM-powered features, allowing users to query news using natural language and receive intelligent summaries.

## Model Context Protocol (MCP) & LLM Capabilities
- The project integrates with MCP, which provides a standardized way to interact with LLMs.
- MCP tools allow the service to:
  - Understand and process natural language queries
  - Summarize news articles
  - Filter and rank news based on semantic relevance
  - Enhance user experience with AI-powered features

## Good Design Choices
- **Configuration Management:** All external dependencies are managed via configuration properties, making the service portable and secure.
- **DTO Usage:** DTOs decouple API contracts from internal models, improving maintainability.
- **Dependency Injection:** Promotes loose coupling and testability.
- **Global Exception Handling:** Ensures consistent error responses and easier debugging.
- **Extensible Service Layer:** New news providers or endpoints can be added with minimal changes.
- **MCP/LLM Integration:** Future-proofs the service by enabling AI-powered features.

## Getting Started
1. Clone the repository
2. Configure API keys and endpoints in the configuration files
3. Build and run the Spring Boot application. Application runs at `http://localhost:8080`
4. Access Swagger doc for all the REST endpoints for news, sources, and headlines at `http://localhost:8080/swagger-ui/index.html#/`

## Example Endpoints
- `/api/v1/external/news-client/api/fetch/all-sources` — Get all news sources
- `/api/v1/external/news-client/api/fetch/all-news` — Get all news articles
- `/api/v1/external/news-client/api/fetch/top-headlines` — Get top headlines

### How to run the application locally in vs code 

- Create .env file and put ```NEWS_API_KEY=<YOUR_NEWS_API_KEY>``` in the .env file
- Export the env vars to the terminal using:
```export $(grep -v '^#' .env | xargs)```
- Run the spring boot app in DEV profile: 
```./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```

- Usefule tip: to kill an already running instance on port 8080, use:
```lsof -ti tcp:8080 | xargs kill -9```

## Conclusion
This project demonstrates a robust, extensible, and modern approach to building a news aggregation service using Spring Boot, with advanced LLM capabilities enabled by MCP. It follows best practices in configuration, dependency management, error handling, and modular design.