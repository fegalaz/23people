package com.auth.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.controller.dto.UserDto;
import com.auth.entity.AuthUser;
import com.auth.repository.UserRepository;
import com.auth.repository.UserRoleRepo;

@Service
public class AuthUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUser register(UserDto userDto) {
       // AuthUser authUser = new ObjectMapper().convertValue(userDto, AuthUser.class);
    	AuthUser entity = new AuthUser();
    	entity.setPassword(passwordEncoder.encode(userDto.getPassword()));
    	entity.setRoles(Collections.singletonList(userRoleRepo.findByRoleNameContaining("USER")));
    	entity.setEmail(userDto.getEmail());
    	entity.setUsername(userDto.getUsername());
    	entity.setMobile(userDto.getMobile());
//        Optional<AuthUser> optUser = userRepository.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
//        Optional<AuthUser> optUser = userRepository.findByUserName(userDto.getUserName());
        Optional<AuthUser> optUser = userRepository.findByUsername(userDto.getUsername());
        
        if (!optUser.isPresent()) {
            return userRepository.save(entity);
        }
        throw new RuntimeException("User already exist");
    }
}
