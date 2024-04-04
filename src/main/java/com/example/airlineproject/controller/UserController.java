package com.example.airlineproject.controller;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.services.PassengerService;
import com.example.airlineproject.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user/")
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {

    private final PassengerService passengerService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody @Valid UserRegisterRequest registerRequest) throws UserException {
        return new ResponseEntity<>(passengerService.register(registerRequest), HttpStatus.CREATED);
    }
}
