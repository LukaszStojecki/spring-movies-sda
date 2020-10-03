package com.sda.movies.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MovieAlReadyExist extends Exception {
    public MovieAlReadyExist(String message) {
        super(message);
    }
}
