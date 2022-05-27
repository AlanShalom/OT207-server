package com.alkemy.ong.auth.controller;

import com.alkemy.ong.dto.UserDto;
import com.alkemy.ong.auth.dto.UserResponseDto;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody UserDto userDto){

        UserResponseDto userResponseDto = iUserService.register(userDto);

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }
}
