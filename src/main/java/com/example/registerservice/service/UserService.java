package com.example.registerservice.service;

import com.example.registerservice.dto.UserRequest;
import com.example.registerservice.dto.UserResponse;
import com.example.registerservice.entity.User;
import com.example.registerservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void adduser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(encoder.encode(userRequest.getPassword()))
                .build();

        userRepository.save(user);
        log.info("User saved {}", user.getId());
    }

    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();

        return user.stream().map(u ->
                UserResponse.builder()
                        .id(u.getId())
                        .username(u.getUsername())
                        .build()).toList();

    }
}
