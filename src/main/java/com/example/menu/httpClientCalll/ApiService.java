package com.example.menu.httpClientCalll;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


// consuming a restFul Api;
@Service
public class ApiService {

    private HttpClient httpClient;

    public ApiService() {

        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

    }

    public CompletableFuture<String> fetchDataAsync() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .timeout(Duration.ofSeconds(5))
                .header("content-type", "application/json")
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(HttpResponse::body);


    }

    public String fetchRetryApi() throws InterruptedException {
        int maxTries = 3;
        int initial = 0;
        while (initial < maxTries) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(""))
                        .timeout(Duration.ofSeconds(5))
                        .header("content-type", "application.json")
                        .GET()
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                return response.body();

            } catch (IOException | InterruptedException e) {
                initial++;
                if (initial >= maxTries) {
                    e.printStackTrace();
                }
                TimeUnit.SECONDS.sleep(2);
            }
        }
        return "";
    }
}
