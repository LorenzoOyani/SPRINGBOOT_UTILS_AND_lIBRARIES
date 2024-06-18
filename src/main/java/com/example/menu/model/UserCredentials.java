package com.example.menu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "USERS")
@Component
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", unique = true, nullable = false, length = 255)
    private String username;
    @Column(name = "password",  nullable = false, length = 255)
    private String password;
    @Column(name = "email",  nullable = false, length = 255)
    private String email;

}
