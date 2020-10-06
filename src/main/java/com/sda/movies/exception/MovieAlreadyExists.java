package com.sda.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MovieAlreadyExists extends Exception {
    public MovieAlreadyExists(String message) {
        super(message);
    }
}
