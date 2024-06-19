package com.example.menu.model;

import com.example.menu.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserCredentials userCredentials = context.getBean(UserCredentials.class);
        userCredentials.setDescription("A prototype kind of bean");
        System.out.println(userCredentials.getDescription());

    }
}
