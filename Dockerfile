# Dockerfile for News Fetcher Service
# This Dockerfile uses the OpenJDK 21 JDK slim image as the base image
# It is designed to build and run the News Fetcher Service application
# Ensure that the application is built with Maven before creating the Docker image
FROM openjdk:21-jdk-slim

# Maintainer information
MAINTAINER Shivam Gaur <shivamgaur4068@gmail.com>

# Copy .env file (optional - for development only)
COPY .env .env

#  Add the application's JAR file to the Docker image
COPY target/news_fetcher_service-0.0.1-SNAPSHOT.jar news_fetcher_service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "news_fetcher_service-0.0.1-SNAPSHOT.jar"]