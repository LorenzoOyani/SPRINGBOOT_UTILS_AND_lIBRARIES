package com.example.menu.repository;

import com.example.menu.model.UserCredentials;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByUsername(String username);

    Optional<UserCredentials> findAllById(Long id);
}
