package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Passenger;
import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.utils.ApiResponse;

public interface PassengerService {
//    Passenger savePassenger(Passenger passenger);
//    Boolean verifyToken(String token);
    ApiResponse register(UserRegisterRequest registerRequest) throws UserException;
}
