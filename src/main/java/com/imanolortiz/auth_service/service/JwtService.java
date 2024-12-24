package com.imanolortiz.auth_service.service;

import com.imanolortiz.auth_service.commons.dtos.AuthResponseDto;
import io.jsonwebtoken.Claims;

public interface JwtService {
    AuthResponseDto generateToken(Long id);
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractUserId(String token);
}
