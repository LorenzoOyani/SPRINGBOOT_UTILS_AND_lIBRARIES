package com.example.menu.service;

import com.example.menu.model.UserCredentials;
import com.example.menu.repository.UserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServices  {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public UserCredentials saveUsers(UserCredentials users) {
        return userRepository.save(users);
    }

    @Override
    public UserCredentials saveUser( UserCredentials users) {
        return userRepository.save(users);
    }

    @Override
    public Optional<UserCredentials> getUserById(Long id) {

        return userRepository.findAllById(id);
    }

    @Override
    public List<UserCredentials> getAllUsers() {
        return userRepository.findAll();
    }
}
