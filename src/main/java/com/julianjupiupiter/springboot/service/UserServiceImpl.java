package com.julianjupiupiter.springboot.service;

import com.julianjupiupiter.springboot.common.MessageSourceProperties;
import com.julianjupiupiter.springboot.dto.CreateUserDto;
import com.julianjupiupiter.springboot.dto.UserDto;
import com.julianjupiupiter.springboot.exception.UsernameAlreadyExistsException;
import com.julianjupiupiter.springboot.mapper.UserMapper;
import com.julianjupiupiter.springboot.repository.UserRepository;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Julian Jupiter
 */
@Service
@Transactional
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;

    UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, MessageSource messageSource) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.messageSource = messageSource;
    }

    @Override
    public List<UserDto> findAll() {
        return this.userRepository.findAll().stream()
                .map(this.userMapper::fromEntityToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public UserDto create(CreateUserDto createUserDto) {
        var username = createUserDto.getUsername();
        this.userRepository.findByUsername(username)
                .ifPresent(user -> {
                    var params = new String[]{username};
                    var message = this.messageSource.getMessage(MessageSourceProperties.USERNAME_ALREADY_EXISTS.toString(), params, Locale.ENGLISH);
                    throw new UsernameAlreadyExistsException(message);
                });
        var email = createUserDto.getEmail();

        this.userRepository.findByEmail(email)
                .ifPresent(user -> {
                    var params = new String[]{email};
                    var message = this.messageSource.getMessage(MessageSourceProperties.EMAIL_ALREADY_EXISTS.toString(), params, Locale.ENGLISH);
                    throw new UsernameAlreadyExistsException(message);
                });

        var user = this.userMapper.fromCreateUserDtoToEntity(createUserDto)
                .setPassword(this.passwordEncoder.encode(createUserDto.getPassword()));
        var createdUser = this.userRepository.save(user);

        return this.userMapper.fromEntityToDto(createdUser);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::fromEntityToDto);
    }
}
