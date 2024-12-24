package com.imanolortiz.auth_service.service.impl;

import com.imanolortiz.auth_service.commons.dtos.AuthResponseDto;
import com.imanolortiz.auth_service.commons.dtos.UserRequest;
import com.imanolortiz.auth_service.commons.entities.UserModel;
import com.imanolortiz.auth_service.repository.UserRepository;
import com.imanolortiz.auth_service.service.AuthService;
import com.imanolortiz.auth_service.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponseDto createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    private UserModel mapToEntity(UserRequest userRequest){
        return UserModel
                .builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .role("USER")
                .build();
    }
}
