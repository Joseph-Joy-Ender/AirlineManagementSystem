package com.example.airlineproject.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {
    public static final String REGISTER_SUCCESSFULLY = "User successfully registered";
    public static final String CUSTOMER_ALREADY_EXIST = "Customer already exist";
    public static final String FLIGHT_WITH_THE_SAME_FIGHT_NUMBER_ALREADY_EXISTS = "Flight with the same flight number already exist";

    public static ApiResponse create(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .isSuccessful(true)
                .build();
    }
}
