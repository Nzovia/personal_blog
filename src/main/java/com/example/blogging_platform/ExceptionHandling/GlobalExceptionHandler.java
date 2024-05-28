package com.example.blogging_platform.ExceptionHandling;

import com.example.blogging_platform.commons.StringResponse;
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
    public ResponseEntity<StringResponse> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StringResponse(ex.getMessage()));
    }

    @ExceptionHandler(ResourceTakenException.class)
    public ResponseEntity<StringResponse>  handleResourceTakenException(ResourceTakenException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new StringResponse(ex.getMessage()));
    }

    @ExceptionHandler(PostRequestException.class)
    public ResponseEntity<StringResponse> handlePostRequestException(PostRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StringResponse(ex.getMessage()));
    }

    @ExceptionHandler(UnAuthorizedRequestException.class)
    public ResponseEntity<StringResponse> handleUnAuthorizedRequestException(UnAuthorizedRequestException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new StringResponse(ex.getMessage())); //403
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StringResponse> handleAccessDeniedException(AccessDeniedException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new StringResponse(ex.getMessage())); //401

    }

}
