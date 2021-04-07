package com.julianjupiupiter.springboot.exception;

/**
 * @author Julian Jupiter
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
