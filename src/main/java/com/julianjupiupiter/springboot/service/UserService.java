package com.julianjupiupiter.springboot.service;

import com.julianjupiupiter.springboot.dto.CreateUserDto;
import com.julianjupiupiter.springboot.dto.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Julian Jupiter
 */
public interface UserService {
    List<UserDto> findAll();

    UserDto create(CreateUserDto createUserDto);

    Optional<UserDto> findById(Long id);
}
