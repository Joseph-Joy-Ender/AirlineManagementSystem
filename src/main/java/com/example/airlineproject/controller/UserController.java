package com.example.airlineproject.controller;

import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.services.UserService;
import com.example.airlineproject.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("registerUser")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody @Valid UserRegisterRequest registerRequest) throws UserException {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                             .body(userService.register(registerRequest));
    }
}
