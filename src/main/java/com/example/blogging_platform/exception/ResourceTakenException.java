package com.example.blogging_platform.exception;

/**
 * @author Nicholas Nzovia
 * @On 15/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public class ResourceTakenException extends RuntimeException{
    public ResourceTakenException(String message) {
        super(message);
    }
}
