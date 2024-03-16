package com.example.airlineproject.services;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.utils.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testRegisterUser() throws UserException {
       UserRegisterRequest registerRequest = new UserRegisterRequest();
       registerRequest.setEmailAddress("joy9403@gmail.com");
       registerRequest.setPassword("678543");
       registerRequest.setFirstName("Joy");

       ApiResponse apiResponse =
       userService.register(registerRequest);

       assertNotNull(apiResponse);
    }

    @Test
    public void testThatExceptionIsThrownWhenUserAlreadyExist() throws UserException {
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setEmailAddress("joy9403@gmail.com");
        registerRequest.setPassword("678543");
        registerRequest.setFirstName("Joy");

        ApiResponse apiResponse =
                userService.register(registerRequest);

        assertThatExceptionOfType(UserException.class).isThrownBy(()-> userService.register(registerRequest));

    }

    @Test
    public void testThatFirstNameCannotBeEmptyOrBlank() throws UserException {
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setEmailAddress("joyjo9403@gmail");
        registerRequest.setPassword("678543");
        registerRequest.setFirstName("joseph");

        ApiResponse apiResponse =
                userService.register(registerRequest);

        assertNotNull(apiResponse);
    }
}
