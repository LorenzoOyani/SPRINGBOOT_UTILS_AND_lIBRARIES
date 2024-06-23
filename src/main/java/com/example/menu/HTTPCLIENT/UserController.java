package com.example.menu.HTTPCLIENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Services services;

    @Autowired
    UserController(Services services) {
        this.services = services;
    }
    
    @PostMapping
    public List<User> addUsers(@RequestBody InputStream inputStream){
        return Services.parseUsers(inputStream);
    }
}
