# news-fetcher-service

### How to run the application locally in vs code 

- Create .env file and put ```NEWS_API_KEY=<YOUR_NEWS_API_KEY>``` in the .env file
- Export the env vars to the terminal using:
```export $(grep -v '^#' .env | xargs)```
- Run the spring boot app in DEV profile: 
```./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```

- Usefule tip: to kill an already running instance on port 8080, use:
```lsof -ti tcp:8080 | xargs kill -9```