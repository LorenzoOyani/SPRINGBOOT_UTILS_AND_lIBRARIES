package com.example.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MenuApplication {

    private static final Logger logger = LoggerFactory.getLogger(MenuApplication.class);

    public static void main(String[] args) {


        SpringApplication.run(MenuApplication.class, args);

    }
//
//    @Bean
//    public CommandLineRunner runner(ApplicationContext ctx) {
//        return args -> {
//            String[] user = ctx.getBeanDefinitionNames();
//            Arrays.sort(user);
//            for (String users : user) {
//                System.out.println(users);
//            }
//
//        };
//    }


}
