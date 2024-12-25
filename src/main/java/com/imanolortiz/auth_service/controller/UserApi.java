package com.imanolortiz.auth_service.controller;

import com.imanolortiz.auth_service.commons.constants.ApiPathConstants;
import com.imanolortiz.auth_service.commons.dtos.UpdateUserDto;
import com.imanolortiz.auth_service.commons.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {

    @GetMapping(value = "/user-info")
    ResponseEntity<UserDto> getUser(@RequestAttribute("X-User-Id") Long userId);

    @DeleteMapping(value = "/delete")
    ResponseEntity<Void> deleteUser(@RequestAttribute("X-User-Id") Long userId);

    @PutMapping(value = "/update")
    ResponseEntity<Void> updateUser(@RequestAttribute("X-User-Id") Long userId, @RequestBody UpdateUserDto dto);

}
