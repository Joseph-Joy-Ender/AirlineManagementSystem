package com.example.airlineproject.services;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.utils.ApiResponse;

public interface UserService {

    ApiResponse register(UserRegisterRequest registerRequest);
}
