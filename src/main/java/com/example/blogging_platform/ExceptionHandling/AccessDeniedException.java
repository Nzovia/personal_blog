package com.example.blogging_platform.ExceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 08/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String message) {
        super(message);
    }
}
