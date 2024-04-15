package com.example.blogging_platform.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Nicholas Nzovia
 * @On 15/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceTakenException extends RuntimeException{
    public ResourceTakenException(String message) {
        super(message);
    }
}
