package com.example.menu.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public  ObjectMapper getInstance() {
        ObjectMapper mapper = new ObjectMapper();


        // Configuring Deserialization Features
        mapper.enable(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // Handling unknown properties gracefully
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
        mapper.enable(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);

        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, true);
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        return mapper;

    }
}
