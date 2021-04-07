package com.julianjupiupiter.springboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Julian Jupiter
 */
public class CreateUserDto {
    private static final String REGEXP_USERNAME = "^[^0-9][a-z0-9]{2,}$";
    private static final String REGEXP_EMAIL = "(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))";
    private static final String REGEXP_MOBILE_NUMBER = "^[0][1-9]\\d{9}$|^[1-9]\\d{9}$";
    private static final String REGEXP_PASSWORD = "[^\\s]*";

    @NotBlank(message = "{NotBlank.createUserDto.username}")
    @Pattern(regexp = REGEXP_USERNAME, message = "{Pattern.createUserDto.username}")
    private String username;
    @NotNull(message = "{NotNull.createUserDto.password}")
    @NotEmpty(message = "{NotEmpty.createUserDto.password}")
    @Pattern(regexp = REGEXP_PASSWORD, message = "{Pattern.createUserDto.password}")
    private String password;
    @NotBlank(message = "{NotBlank.createUserDto.firstName}")
    private String firstName;
    private String middleName;
    @NotBlank(message = "{NotBlank.createUserDto.lastName}")
    private String lastName;
    private String extensionName;
    @NotNull(message = "{NotNull.createUserDto.email}")
    @Email(regexp = REGEXP_EMAIL, message = "{Email.createUserDto.email}")
    private String email;
    @Pattern(regexp = REGEXP_MOBILE_NUMBER, message = "{Pattern.createUserDto.mobileNumber}")
    private String mobileNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
