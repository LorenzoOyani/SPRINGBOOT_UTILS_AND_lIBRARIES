package com.example.menu;

import com.example.menu.controlller.UserController;
import com.example.menu.model.UserCredentials;
import com.example.menu.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(UserController.class)
@ActiveProfiles("Test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        UserCredentials user = new UserCredentials();
        user.setId(1L);
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        when(userService.saveUsers(any(UserCredentials.class))).thenReturn(user);

        mockMvc.perform(post("/api/userCredentials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"username\": \"testUser\", \"password\": \"password123\", \"email\": \"test@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"id\": 1, \"username\": \"testUser\", \"password\": \"password123\", \"email\": \"test@example.com\"}"));
    }

    @Test
    public void testGetUserById() throws Exception {
        UserCredentials user = new UserCredentials();
        user.setId(1L);
        user.setUsername("testUser");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        when(userService.getUserById(1L)).thenReturn(Optional.of(user));
        mockMvc.perform(get("/api/usersCredentials/1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("id").value(1))
                .andExpect((ResultMatcher) jsonPath("$ name").value("testUser"))
                .andExpect((ResultMatcher) jsonPath("$ test@example.com"));

    }
}
