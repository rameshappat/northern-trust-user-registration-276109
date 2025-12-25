package com.northerntrust.registration;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterUser() throws Exception {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setUsername("testuser");
        request.setEmail("testuser@example.com");
        request.setPassword("password123");

        mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Registration successful. Please check your email for OTP."));
    }

    @Test
    public void testVerifyOtp() throws Exception {
        mockMvc.perform(post("/api/register/verify")
                .param("email", "testuser@example.com")
                .param("otp", "123456"))
                .andExpect(status().isOk())
                .andExpect(content().string("OTP verified successfully."));
    }
}