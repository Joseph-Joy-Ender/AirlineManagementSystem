package com.example.airlineproject.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {
    @NotBlank(message = "First name cannot be blank")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password can not be blank")
    private String password;
    @NotBlank
    @NotEmpty
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String emailAddress;

}
