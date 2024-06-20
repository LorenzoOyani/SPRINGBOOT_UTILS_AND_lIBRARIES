package com.example.menu.HTTPCLIENT;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class HttpUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String USER_API = "https://jsonplaceholder.typicode.com/users";

    private HttpUtils() {
    }


    /**
     * Converts JSON data from an InputStream to a list of User objects.
     *
     * @param inputStream the InputStream containing JSON data
     * @return a List of User objects
     * @throws IOException if there's an error processing the JSON
     */
    public static List<User> toList(InputStream inputStream) throws IOException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        TypeFactory typeFactory = mapper.getTypeFactory();


        return mapper.readValue(inputStream, typeFactory.constructCollectionType(List.class, User.class));

    }


}
