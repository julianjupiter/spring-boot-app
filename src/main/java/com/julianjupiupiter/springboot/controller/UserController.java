package com.julianjupiupiter.springboot.controller;

import com.julianjupiupiter.springboot.common.MessageSourceProperties;
import com.julianjupiupiter.springboot.dto.CreateUserDto;
import com.julianjupiupiter.springboot.dto.UserDto;
import com.julianjupiupiter.springboot.exception.ResourceNotFoundException;
import com.julianjupiupiter.springboot.exception.ValidationException;
import com.julianjupiupiter.springboot.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Julian Jupiter
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;
    private final MessageSource messageSource;

    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return this.userService.findAll();
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserDto createUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var errors = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> {
                        String fieldErrorCode = fieldError.getCode();
                        String field = fieldError.getField();
                        String[] resolveMessageCodes = bindingResult.resolveMessageCodes(fieldErrorCode);
                        return this.messageSource.getMessage(resolveMessageCodes[0] + "." + field,
                                new Object[]{fieldError.getRejectedValue()}, Locale.ENGLISH);
                    }).collect(Collectors.toUnmodifiableList());
            throw new ValidationException("Invalid data", errors);
        }

        var userDto = this.userService.create(createUserDto);

        return ResponseEntity.created(URI.create("/v1/users/" + userDto.getId()))
                .body(userDto);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return this.userService.findById(id)
                .orElseThrow(() -> {
                    var params = new Long[]{id};
                    var message = this.messageSource.getMessage(MessageSourceProperties.USER_NOT_FOUND.toString(), params, Locale.ENGLISH);
                    return new ResourceNotFoundException(message);
                });
    }
}
