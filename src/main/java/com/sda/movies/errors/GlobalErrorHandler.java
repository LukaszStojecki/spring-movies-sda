package com.sda.movies.errors;


import com.sda.movies.exception.EntityAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneralExists(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(e.getMessage()));
    }


    @ExceptionHandler(value = EntityAlreadyExistException.class)
    public ResponseEntity<Object> handleEntityExists(EntityAlreadyExistException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorDTO(e.getMessage()));

    }

}
