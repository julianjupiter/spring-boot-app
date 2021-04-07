package com.julianjupiupiter.springboot.exception;

import java.util.List;

/**
 * @author Julian Jupiter
 */
public class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
