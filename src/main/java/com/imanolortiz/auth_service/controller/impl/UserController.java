package com.imanolortiz.auth_service.controller.impl;

import com.imanolortiz.auth_service.commons.dtos.UpdateUserDto;
import com.imanolortiz.auth_service.commons.dtos.UserDto;
import com.imanolortiz.auth_service.controller.UserApi;
import com.imanolortiz.auth_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private UserService userService;

    UserController(UserService userService){
        this.userService= userService;
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> updateUser(Long userId, UpdateUserDto dto) {
        userService.updateUser(userId, dto);
        return ResponseEntity.noContent().build();
    }
}
