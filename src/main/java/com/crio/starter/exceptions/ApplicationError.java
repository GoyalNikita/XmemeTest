package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationError extends Exception {
    public ApplicationError() {
        super(DEFAULT_MSG);
    }
    private static final String DEFAULT_MSG = "Server side error. Please try again.";

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;


    public ApplicationError(String messageString) {
        super(messageString);
    }

    public ApplicationError(String messageString, HttpStatus httpStatus) {
        super(messageString);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
