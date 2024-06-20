package com.example.menu.Jackson_Library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class CustomCollections {

    private  ObjectMapper mapper;

    CustomCollections() {
    }


    /**
     * @throws java.io.IOException if there is an error processing the JSON
     **/
    public void main(String[] args) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

        TypeFactory typeFactory = mapper.getTypeFactory();


        String jsonArray = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";
        InputStream inputStream = new ByteArrayInputStream(jsonArray.getBytes(StandardCharsets.UTF_8));
        List<User> userList = mapper.readValue(inputStream, typeFactory.constructCollectionType(List.class, User.class));
        for (User user : userList) {
            System.out.println(user);
        }


    }

}

