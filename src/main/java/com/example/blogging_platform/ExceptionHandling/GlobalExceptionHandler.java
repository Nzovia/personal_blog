package com.example.blogging_platform.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Nicholas Nzovia
 * @On 28/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }

    @ExceptionHandler(ResourceTakenException.class)
    public ResponseEntity<ExceptionResponseBody>  handleResourceTakenException(ResourceTakenException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }

    @ExceptionHandler(PostRequestException.class)
    public ResponseEntity<ExceptionResponseBody> handlePostRequestException(PostRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseBody(ex.getMessage(), ex.getCause()));
    }


}
