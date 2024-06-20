package com.example.menu.jsonHelper;


import com.example.menu.HTTPCLIENT.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class JsonHelper {
    private static ObjectMapper mapper;

    @Autowired
    public JsonHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    JsonHelper() {
    }

    /**
     * @param <T> typed parameter.
     * @throws IOException if there is an error processing the json.
     * @return deserialize Json to List of Object typeInference
     **/

    public static  <T> List<T> fromJsonToList(InputStream inputStream, Class<T> clazz) throws IOException {
        TypeFactory typeFactory = mapper.getTypeFactory();

        return mapper.readValue(inputStream, typeFactory.constructCollectionType(List.class, clazz));


    }

    /**
     * @throws IOException if the Json cant  be deserialized to Object.
     **/
    public static <T> T fromJson(InputStream inputStream, Class<T> tClass) throws IOException {
        return mapper.readValue(inputStream, tClass);
    }

    /**
     * @throws JsonProcessingException if the object is not properly serialized.
     **/
    public static String toJson(User user) throws JsonProcessingException {
        return mapper.writeValueAsString(user);

    }
}
