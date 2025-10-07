package com.userservice.services;

import com.userservice.dtos.AuthResponse;
import com.userservice.dtos.LoginRequest;
import com.userservice.dtos.RegisterRequest;
import com.userservice.dtos.UpdateUserRequest;
import com.userservice.entities.User;

import java.util.List;

public interface UserService {

    User register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);

    void logout(String req);

    AuthResponse refreshToken(String req);

    User updateUser(Long id, UpdateUserRequest res);

    User getByName(String authentication);

    User getById(Long id);

    User getByUserName(String username);

    User saveUser(User user);
    List<User> getAllUser();

}
