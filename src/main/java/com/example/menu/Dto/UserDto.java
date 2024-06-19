package com.example.menu.Dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
