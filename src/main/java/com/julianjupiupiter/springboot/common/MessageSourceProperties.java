package com.julianjupiupiter.springboot.common;

/**
 * @author Julian Jupiter
 */
public enum MessageSourceProperties {


    EMAIL_ALREADY_EXISTS("email.already.exists"),
    USER_NOT_FOUND("user.not.found"),
    USERNAME_ALREADY_EXISTS("username.already.exists");

    private final String value;

    private MessageSourceProperties(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
