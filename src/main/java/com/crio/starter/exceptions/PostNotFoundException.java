package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends ApplicationError {
    private static final String DEFAULT_MESSAGE = "The post you searched for is not found!";

    public PostNotFoundException() {
        super(DEFAULT_MESSAGE, HttpStatus.NOT_FOUND);
    }

    public PostNotFoundException(String messageString) {
        super(messageString, HttpStatus.NOT_FOUND);
    }
}
