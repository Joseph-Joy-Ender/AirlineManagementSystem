package com.example.airlineproject.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {
    public static final String REGISTER_SUCCESSFULLY = "User successfully registered";
    public static final String CUSTOMER_ALREADY_EXIST = "Customer already exist";

    public static ApiResponse create(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .isSuccessful(true)
                .build();
    }
}
