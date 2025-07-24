package com.sg_tech.news_fetcher_service.external_news_client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidConfigValueException extends IllegalArgumentException{
    public InvalidConfigValueException(String message) {
        super(message);
    }
}
