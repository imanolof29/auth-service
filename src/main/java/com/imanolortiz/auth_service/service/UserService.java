package com.imanolortiz.auth_service.service;

import com.imanolortiz.auth_service.commons.dtos.UpdateUserDto;
import com.imanolortiz.auth_service.commons.dtos.UserDto;

public interface UserService {
    UserDto getUser(Long id);
    void updateUser(Long id, UpdateUserDto dto);
    void deleteUser(Long id);
}
