package com.example.menu;

import com.example.menu.model.UserCredentials;
import com.example.menu.repo.UserCredentialsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MenuApplication {

    private static final Logger logger = LoggerFactory.getLogger(MenuApplication.class);

    public static void main(String[] args) {


      ApplicationContext context  =  SpringApplication.run(MenuApplication.class, args);
            UserCredentials credentials = context.getBean(UserCredentials.class);
            credentials.setId(1L);
            credentials.setUsername("Jon");
            credentials.setPassword("12345");
            credentials.setEmail("Jerumehlawrence@gmail.com");

        UserCredentialsRepo repo = context.getBean(UserCredentialsRepo.class);
        repo.saveUser(credentials);

        System.out.println( repo.findAllUsers());





    }

    public  CommandLineRunner myRunner() {
        return args -> {
            System.out.println("running...");
        };
    }

}
