package com.example.menu.Jackson_Library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomDeserializer {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        mapper.registerModule(module);

        JsonNode node = mapper.readTree("user.json");
        String name = node.path("name").asText();
        int age = node.path("age").asInt();
        System.out.println(name);
        System.out.println(age);
    }
}
