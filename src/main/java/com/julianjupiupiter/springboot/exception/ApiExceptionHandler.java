package com.julianjupiupiter.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Julian Jupiter
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ExceptionResponse.of(HttpStatus.NOT_FOUND, OffsetDateTime.now(), List.of(exception.getMessage()));
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponse handleUsernameAlreadyExistsException(UsernameAlreadyExistsException exception) {
        return ExceptionResponse.of(HttpStatus.UNPROCESSABLE_ENTITY, OffsetDateTime.now(), List.of(exception.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return ExceptionResponse.of(HttpStatus.UNPROCESSABLE_ENTITY, OffsetDateTime.now(), List.of(exception.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResponse handleValidationException(ValidationException exception) {
        return ExceptionResponse.of(HttpStatus.UNPROCESSABLE_ENTITY, OffsetDateTime.now(), exception.getErrors());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleOtherException(Exception exception) {
        exception.printStackTrace();
        return ExceptionResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, OffsetDateTime.now(), List.of(exception.getMessage()));
    }
}
