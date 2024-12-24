package com.imanolortiz.auth_service.controller.impl;

import com.imanolortiz.auth_service.commons.dtos.AuthResponseDto;
import com.imanolortiz.auth_service.commons.dtos.UserRequest;
import com.imanolortiz.auth_service.controller.AuthApi;
import com.imanolortiz.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private AuthService authService;

    AuthController(AuthService authService){
        this.authService = authService;
    }

    @Override
    public ResponseEntity<AuthResponseDto> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}
