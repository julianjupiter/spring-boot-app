package com.julianjupiupiter.springboot.exception;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Julian Jupiter
 */
public class ExceptionResponse {
    private final int code;
    private final String error;
    private final OffsetDateTime createdAt;
    private final List<String> errors;

    private ExceptionResponse(HttpStatus status, OffsetDateTime createdAt, List<String> errors) {
        this.code = status.value();
        this.error = status.getReasonPhrase();
        this.createdAt = createdAt;
        this.errors = errors;
    }

    public static ExceptionResponse of(HttpStatus status, OffsetDateTime createdAt, List<String> errors) {
        return new ExceptionResponse(status, createdAt, errors);
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public List<String> getErrors() {
        return errors;
    }
}
