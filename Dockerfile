# Dockerfile for News Fetcher Service
# This Dockerfile uses a multi-stage build to first build the application with Maven
# and then run it with OpenJDK 21 JDK slim image

# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (for better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:21-jdk-slim

# Maintainer information
LABEL maintainer="Shivam Gaur <shivamgaur4068@gmail.com>"

# Copy .env file (optional - for development only)
COPY .env .env

# Copy the JAR file from the build stage
COPY --from=build /app/target/news_fetcher_service-0.0.1-SNAPSHOT.jar news_fetcher_service-0.0.1-SNAPSHOT.jar

# Expose port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "news_fetcher_service-0.0.1-SNAPSHOT.jar"]