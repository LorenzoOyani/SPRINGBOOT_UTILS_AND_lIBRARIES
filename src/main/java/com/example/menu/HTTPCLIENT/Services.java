package com.example.menu.HTTPCLIENT;

import com.example.menu.jsonHelper.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class Services {



    public static List<User> parseUsers(InputStream inputStream) {
        try {
            return JsonHelper.fromJsonToList(inputStream, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User fromJson(InputStream inputStream) {
        try {
            return JsonHelper.fromJson(inputStream, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(User user) {
        try {
            return JsonHelper.toJson(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}