package com.sda.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityAlreadyExistException extends Exception {
    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
