package com.example.menu.service;

import com.example.menu.model.UserCredentials;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    UserCredentials saveUsers(UserCredentials users);

    UserCredentials saveUser(UserCredentials user);

    Optional<UserCredentials> getUserById(Long id);

    List<UserCredentials> getAllUsers();
}
