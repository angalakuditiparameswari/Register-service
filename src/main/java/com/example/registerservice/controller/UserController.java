package com.example.registerservice.controller;

import com.example.registerservice.dto.UserRequest;
import com.example.registerservice.dto.UserResponse;
import com.example.registerservice.entity.User;
import com.example.registerservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/register")
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@Valid @RequestBody UserRequest userRequest) {
        userService.adduser(userRequest);
        return "User registered successfully "+userRequest.getUsername();
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getUsers() {
        return userService.getAllUsers();
    }
}
