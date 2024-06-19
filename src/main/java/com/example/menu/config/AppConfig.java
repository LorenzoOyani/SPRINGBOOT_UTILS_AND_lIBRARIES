package com.example.menu.config;

import com.example.menu.controlller.UserController;
import com.example.menu.model.UserCredentials;
import com.example.menu.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.example.menu")
@Scope("singleton")
public class AppConfig {
    @Bean
    public UserCredentials userCredentials() {
        return new UserCredentials();
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
          System.out.println("Just starting out..");
        };

    }


}
