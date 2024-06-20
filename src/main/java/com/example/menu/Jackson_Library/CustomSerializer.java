package com.example.menu.Jackson_Library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomSerializer {




    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addSerializer(User.class, new userSerializer());
        mapper.registerModule(module);

        User user = new User("LA", 40);
        String jsonTypeString = mapper.writeValueAsString(user);
        System.out.println(jsonTypeString);






    }

}


