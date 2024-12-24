package com.imanolortiz.auth_service.service.impl;

import com.imanolortiz.auth_service.commons.dtos.UpdateUserDto;
import com.imanolortiz.auth_service.commons.dtos.UserDto;
import com.imanolortiz.auth_service.commons.entities.UserModel;
import com.imanolortiz.auth_service.repository.UserRepository;
import com.imanolortiz.auth_service.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserDetailsImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new RuntimeException("UserDetailsService user not found"));
    }

    @Override
    public UserDto getUser(Long id) {
        return Optional.of(id)
                .flatMap(userRepository::findById)
                .map(this::mapToEntity)
                .orElseThrow(() -> new RuntimeException("Error retrieving user with id "+id));
    }

    @Override
    public void updateUser(Long id, UpdateUserDto dto) {
        Optional.of(id)
                .map(this::getUserById)
                .map(user -> updateUserFields(user, dto))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Error updating user with id "+id));
    }

    @Override
    public void deleteUser(Long id) {
        Optional.of(id)
                .map(this::getUserById)
                .ifPresent(userRepository::delete);
    }

    private UserModel updateUserFields(UserModel user, UpdateUserDto dto){
        user.setName(dto.getName());
        return user;
    }

    private UserModel getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error retrieving user with ID "+id));
    }

    private UserDto mapToEntity(UserModel user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
