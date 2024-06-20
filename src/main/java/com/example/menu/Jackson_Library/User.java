package com.example.menu.Jackson_Library;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {
    @JsonProperty(namespace = "user_name")
    private String name;
    @JsonProperty(namespace = "custom_age")
    private int age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-mm-dd hh:mm:ss")
    private Date localDate;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
