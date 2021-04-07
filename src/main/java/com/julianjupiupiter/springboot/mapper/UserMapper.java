package com.julianjupiupiter.springboot.mapper;

import com.julianjupiupiter.springboot.dto.CreateUserDto;
import com.julianjupiupiter.springboot.dto.UserDto;
import com.julianjupiupiter.springboot.entity.User;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * @author Julian Jupiter
 */
@Component
public class UserMapper {
    public UserDto fromEntityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getExtensionName(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getCreatedAt()
        );
    }

    public User fromCreateUserDtoToEntity(CreateUserDto createUserDto) {
        return new User()
                .setUsername(createUserDto.getUsername())
                .setFirstName(createUserDto.getFirstName())
                .setMiddleName(createUserDto.getMiddleName())
                .setLastName(createUserDto.getLastName())
                .setExtensionName(createUserDto.getExtensionName())
                .setEmail(createUserDto.getEmail())
                .setMobileNumber(createUserDto.getMobileNumber())
                .setCreatedAt(OffsetDateTime.now());
    }
}
