package com.example.menu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.http.HttpClient;

@ExtendWith(MockitoExtension.class)
public class httpClientTestCases {

    @Test
    public  void setUp() {
        HttpClient mockClient = Mockito.mock(HttpClient.class);




    }
}
