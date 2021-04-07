package com.julianjupiupiter.springboot.dto;

import java.time.OffsetDateTime;

/**
 * @author Julian Jupiter
 */
public class UserDto {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String extensionName;
    private final String email;
    private final String mobileNumber;
    private final OffsetDateTime createdAt;

    public UserDto(Long id,
                   String username,
                   String firstName,
                   String middleName,
                   String lastName,
                   String extensionName,
                   String email,
                   String mobileNumber,
                   OffsetDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.extensionName = extensionName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
