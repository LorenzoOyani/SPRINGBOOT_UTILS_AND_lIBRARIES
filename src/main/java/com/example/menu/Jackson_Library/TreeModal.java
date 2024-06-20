package com.example.menu.Jackson_Library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TreeModal {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\"name\":\"Alice\",\"details\":{\"age\":30,\"city\":\"New York\"}}";
        JsonNode node = mapper.readTree(jsonString);
        String name = node.path("name").asText();
        int age = node.path("details").path("age").asInt();
        String city = node.path("city").asText();
        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
    }
}
