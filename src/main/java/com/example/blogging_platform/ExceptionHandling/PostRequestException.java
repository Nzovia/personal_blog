package com.example.blogging_platform.ExceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class PostRequestException extends RuntimeException{
    public PostRequestException(String message) {
        super(message);
    }
}
