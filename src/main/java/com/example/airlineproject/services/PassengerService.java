package com.example.airlineproject.services;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.utils.ApiResponse;

public interface PassengerService {

    ApiResponse register(UserRegisterRequest registerRequest) throws UserException;
}
