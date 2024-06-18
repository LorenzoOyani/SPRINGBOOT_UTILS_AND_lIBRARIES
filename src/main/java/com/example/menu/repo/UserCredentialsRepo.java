package com.example.menu.repo;

import com.example.menu.model.UserCredentials;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserCredentialsRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplate template(JdbcTemplate template) {
        return this.jdbcTemplate = template;
    }

    public void saveUser(UserCredentials user) {
        String sql = "insert into USERS(id, user_name, password, email) values (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
        System.out.println(rows + " affected");
    }

    public List<UserCredentials> findAllUsers() {

        String sql = "select * from users";

        RowMapper<UserCredentials> mapper = new RowMapper<UserCredentials>() {
            @Override
            public UserCredentials mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
                UserCredentials credentials = new UserCredentials();
                credentials.setId(rs.getLong(1));
                credentials.setUsername(rs.getString(2));
                credentials.setPassword(rs.getString(3));
                credentials.setEmail(rs.getString(4));

                return credentials;

            }
        };

        return jdbcTemplate.query(sql, mapper);

    }


}
