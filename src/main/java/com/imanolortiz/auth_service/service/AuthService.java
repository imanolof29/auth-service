package com.imanolortiz.auth_service.service;

import com.imanolortiz.auth_service.commons.dtos.AuthResponseDto;
import com.imanolortiz.auth_service.commons.dtos.LoginRequestDto;
import com.imanolortiz.auth_service.commons.dtos.UserRequest;

public interface AuthService {

    AuthResponseDto createUser(UserRequest userRequest);

    AuthResponseDto loginUser(LoginRequestDto loginRequestDto);

}
