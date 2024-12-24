package com.imanolortiz.auth_service.controller;

import com.imanolortiz.auth_service.commons.constants.ApiPathConstants;
import com.imanolortiz.auth_service.commons.dtos.UpdateUserDto;
import com.imanolortiz.auth_service.commons.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {

    @GetMapping(value = "/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable Long userId);

    @DeleteMapping(value = "/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);

    @PutMapping(value = "/{userId}")
    ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto dto);

}
