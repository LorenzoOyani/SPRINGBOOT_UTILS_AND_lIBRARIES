package com.example.menu.controlller;

import com.example.menu.Dto.UserDto;
import com.example.menu.model.UserCredentials;
import com.example.menu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCredentials> createUser(@RequestBody UserDto userDto) {
        UserCredentials users = new UserCredentials();
        users.setUsername(userDto.getUsername());
        users.setPassword(userDto.getPassword());
        users.setEmail(userDto.getEmail());
       UserCredentials createdUser =  userService.saveUsers(users);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/usersCredentials/{id}")
    public ResponseEntity<Long> getUsersById(@PathVariable Long id) {
        Optional<UserCredentials> userOptional = userService.getUserById(id);
        return userOptional
                .map(user -> new ResponseEntity<>(user.getId(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
