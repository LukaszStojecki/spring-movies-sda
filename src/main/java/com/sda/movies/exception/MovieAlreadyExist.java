package com.sda.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MovieAlreadyExist extends Exception {
    public MovieAlreadyExist(String message) {
        super(message);
    }
}