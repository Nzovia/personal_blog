package com.example.blogging_platform.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostRequestException extends RuntimeException{
    public PostRequestException(String message) {
        super(message);
    }
}
