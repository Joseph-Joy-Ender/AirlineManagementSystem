package com.example.airlineproject.controllers;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class PassengerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper = new ObjectMapper();
    @Test
    public void testRegisterUser() throws Exception{
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setFirstName("Joy");
        registerRequest.setPassword("123456");
        registerRequest.setEmailAddress("ben123@gmail.com");


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(registerRequest)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

    }

}
