package com.example.menu.controlller;

import com.example.menu.model.UserCredentials;
import com.example.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/userCredentials")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCredentials> createUser(UserCredentials user) {
        return new ResponseEntity<UserCredentials>(userService.saveUsers(user), HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<UserCredentials>> getUsersById(@PathVariable Long id) {
        return Optional.of(userService.getUserById(id))
                .map(users -> new ResponseEntity<>(users, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
