package com.example.menu;

import com.example.menu.config.AppConfig;
import com.example.menu.controlller.UserController;
import com.example.menu.model.UserCredentials;
import com.example.menu.repo.UserCredentialsRepo;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MenuApplication {

    private static final Logger logger = LoggerFactory.getLogger(MenuApplication.class);

    public static void main(String[] args) {


       SpringApplication.run(MenuApplication.class, args);

    }

    @Bean
    public CommandLineRunner runner(UserCredentials userCredentials, UserCredentialsRepo repo) {
        return args -> {
            userCredentials.setId(1L);
            userCredentials.setUsername("Jane");
            userCredentials.setPassword("123");
            userCredentials.setEmail("jane@gmail.com");

        };
    }



}
