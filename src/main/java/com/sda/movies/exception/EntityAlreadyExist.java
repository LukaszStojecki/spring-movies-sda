package com.sda.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityAlreadyExist extends Exception {
    public EntityAlreadyExist(String message) {
        super(message);
    }
}
