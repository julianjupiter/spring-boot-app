package com.julianjupiupiter.springboot.exception;

/**
 * @author Julian Jupiter
 */
public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
