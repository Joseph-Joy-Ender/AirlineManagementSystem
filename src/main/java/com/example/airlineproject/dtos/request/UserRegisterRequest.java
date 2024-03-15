package com.example.airlineproject.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {
    private String firstName;
    private String password;
    private String emailAddress;

}
