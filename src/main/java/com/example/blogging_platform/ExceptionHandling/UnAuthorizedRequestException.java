package com.example.blogging_platform.ExceptionHandling;

/**
 * @author Nicholas Nzovia
 * @On 28/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class UnAuthorizedRequestException extends RuntimeException{
    public UnAuthorizedRequestException(String message){
        super(message);
    }
}
