package com.example.airlineproject.services;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AllArgsConstructor
public class UserServiceTest {

    private final UserService userService;


    @Test
    public void testRegisterUser(){
       UserRegisterRequest registerRequest = new UserRegisterRequest();
       registerRequest.setEmailAddress("joy9403@gmail.com");
       registerRequest.setPassword("678543");
       registerRequest.setFirstName("Joy");

       ApiResponse apiResponse =
       userService.register(registerRequest);

       assertNotNull(apiResponse);





    }
}
