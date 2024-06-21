package com.example.menu.HTTPCLIENT;

import com.example.menu.jsonHelper.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class UserHttpList {
    private static final String USER_API = "https://jsonplaceholder.typicode.com/users";
    private static final Logger log = LoggerFactory.getLogger(UserHttpList.class);

    private Services services;

    @Autowired
    UserHttpList(Services services) {
        this.services = services;
    }

    public void listUsers() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(USER_API)).GET().build();

        try {
            HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            int statusCode = response.statusCode();
            System.out.println(STR."statusCode retrieved \{statusCode}");
            response.headers().map().forEach((headers, value)-> System.out.println(headers + " = " + String.join("," + value)));
            List<User> list = Services.parseUsers(response.body());
            for (User user : list) {
                System.out.println(user);
            }



        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
