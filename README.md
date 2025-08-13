
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
- Aspect-Oriented Programming (AOP) for cross-cutting concerns like logging and validation
- MCP integration for LLM-powered news search and summarization

## Architecture & Design Principles
- **Separation of Concerns:** Controllers, services, DTOs, models, and configuration are clearly separated.
- **Dependency Injection:** All dependencies are injected using Spring's `@Autowired` or constructor injection, promoting testability and loose coupling.
- **Configuration Properties:** External API endpoints, keys, and other settings are managed via `@ConfigurationProperties` classes, making the service environment-agnostic and easy to configure.
- **DTOs and Models:** Data Transfer Objects (DTOs) are used for API requests and responses, while domain models encapsulate business logic.
- **Global Exception Handler:** A `@ControllerAdvice` class handles exceptions across the application, providing consistent error responses.
- **Aspect-Oriented Programming (AOP):** Cross-cutting concerns like logging, validation, and performance monitoring are handled through aspects, keeping business logic clean and focused.
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
- **Aspects (AOP):**
  - `NewsClientServiceLoggerAspect` provides comprehensive logging for method execution, parameters, and performance metrics.
  - `NewsClientServiceRequestCheckAspect` validates request parameters and configuration before method execution.
  - Cross-cutting concerns are cleanly separated from business logic using Spring AOP.
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

## Aspect-Oriented Programming (AOP) Implementation

The project leverages Spring AOP to handle cross-cutting concerns efficiently, keeping business logic clean and focused. The following aspects are implemented:

### 1. **NewsClientServiceLoggerAspect**
- **Purpose:** Comprehensive logging and performance monitoring
- **Features:**
  - Logs method entry, exit, and execution time
  - Captures method parameters and return values
  - Provides detailed error logging with stack traces
  - Performance metrics for API calls
- **Pointcut:** `@Around("execution(* com.sg_tech.news_fetcher_service.external_news_client.service.impl.*.*(..))")`
- **Order:** `@Order(2)` - Runs after validation aspects

### 2. **NewsClientServiceRequestCheckAspect**
- **Purpose:** Request validation and configuration checks
- **Features:**
  - Validates request DTOs before method execution
  - Ensures required parameters are properly configured
  - Throws meaningful exceptions for invalid requests
  - Logs validation success/failure
- **Pointcut:** `@Before("execution(...) && args(requestDto)")`
- **Order:** `@Order(1)` - Runs before logging aspects

### AOP Benefits in This Project:
- **Separation of Concerns:** Business logic remains clean without logging/validation code
- **Code Reusability:** Same aspects apply to all service methods
- **Maintainability:** Easy to modify logging or validation behavior in one place
- **Performance Monitoring:** Automatic timing and performance metrics
- **Consistent Error Handling:** Uniform error logging across all services
- **Non-intrusive:** Existing business logic doesn't need modification

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
- **Aspect-Oriented Programming:** Cross-cutting concerns like logging, validation, and monitoring are cleanly separated from business logic, improving code maintainability and reducing duplication.
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
- Optional env vars:
  ```SPRING_PROFILES_ACTIVE=<PROFILE>```
  ```SERVER_PORT=<PORT_NO>```
- Export the env vars to the terminal using:
```export $(grep -v '^#' .env | xargs)```
- Run the spring boot app in DEV profile: 
```mvn spring-boot:run```

- Useful tip: to kill an already running instance on port 8080, use:
```lsof -ti tcp:8080 | xargs kill -9```

## Helpful mvn commands

- ```mvn clean install``` - compile the maven application
- ```mvn spring-boot:run``` - run the spring boot app


## Running with Docker

### Local Development
- Create .env file and put ```NEWS_API_KEY=<YOUR_NEWS_API_KEY>``` in the .env file
- Optional env vars:
  ```SPRING_PROFILES_ACTIVE=<PROFILE>```
  ```SERVER_PORT=<PORT_NO>```

#### Option 1: Build locally then tag for Docker Hub
```bash
# Build with local name
docker build . -t news-fetcher-service:latest
# Run locally
docker run --env-file .env -p 8080:8080 news-fetcher-service:latest
# Tag for Docker Hub (retagging required)
docker tag news-fetcher-service:v1 sgaurtech/news-fetcher-service:latest
```

#### Option 2: Build directly with Docker Hub name (no retagging needed)
```bash
# Build directly with Docker Hub name
docker build . -t sgaurtech/news-fetcher-service:latest
# Run locally
docker run --env-file .env -p 8080:8080 sgaurtech/news-fetcher-service:latest
# Push directly (no retagging needed)
docker push sgaurtech/news-fetcher-service:latest
```

#### Building without cache (for fresh builds with code changes)
```bash
# Build without using any cached layers
docker build --no-cache -t sgaurtech/news-fetcher-service:latest .

# Remove existing image and rebuild completely
docker rmi sgaurtech/news-fetcher-service:latest
docker build -t sgaurtech/news-fetcher-service:latest .

# Clean up all unused images and rebuild
docker system prune -af
docker build -t sgaurtech/news-fetcher-service:latest .
```

### Using Docker Compose
```bash
# Build and run with docker-compose
docker-compose up --build

# Run in background
docker-compose up -d --build

# Force rebuild without cache (when you have code changes)
docker-compose build --no-cache
docker-compose up

# Complete cleanup and rebuild (removes all cached layers)
docker-compose down --volumes --remove-orphans
docker-compose build --no-cache
docker-compose up

# Stop and remove containers, then rebuild with latest changes
docker-compose down && docker-compose up --build
```

### Pushing to Docker Hub
```bash
# Login to Docker Hub
docker login

# Tag the image for Docker Hub (if option 1 is used above)
docker tag news-fetcher-service:v1 sgaurtech/news-fetcher-service:latest

# Push to Docker Hub
docker push sgaurtech/news-fetcher-service:latest
```

### Troubleshooting Docker Issues

#### When Docker doesn't pick up code changes:
```bash
# Stop all containers and remove them
docker-compose down

# Remove the specific image
docker rmi sgaurtech/news-fetcher-service:latest

# Rebuild without cache
docker-compose build --no-cache

# Start containers
docker-compose up
```

#### Complete Docker cleanup (nuclear option):
```bash
# Stop all containers
docker stop $(docker ps -aq)

# Remove all containers
docker rm $(docker ps -aq)

# Remove all images
docker rmi $(docker images -q) --force

# Remove all volumes and networks
docker system prune -af --volumes

# Rebuild everything
docker-compose build --no-cache
docker-compose up
```

### Running from Docker Hub
```bash
# Pull and run from Docker Hub
docker run --env-file .env -p 8080:8080 sgaurtech/news-fetcher-service:latest
```