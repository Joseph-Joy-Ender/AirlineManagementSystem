package com.example.airlineproject.controller;

import com.example.airlineproject.data.models.Passenger;
import com.example.airlineproject.dtos.request.UserRegisterRequest;
import com.example.airlineproject.dtos.response.HttpResponse;
import com.example.airlineproject.exceptions.UserException;
import com.example.airlineproject.services.PassengerService;
import com.example.airlineproject.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/user/")
@CrossOrigin("*")
@AllArgsConstructor

public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody @Valid UserRegisterRequest registerRequest) throws UserException {
        return new ResponseEntity<>(passengerService.register(registerRequest), HttpStatus.CREATED);
    }

//   @PostMapping
//    public ResponseEntity<HttpResponse> createUser(@RequestBody Passenger passenger){
//       passengerService.savePassenger(passenger);
//       return ResponseEntity.created(URI.create("")).body(
//               HttpResponse.builder()
//                       .timeStamp(LocalDateTime.now().toString())
//                       .data(Map.of("Passenger", passenger))
//                       .message("Passenger created")
//                       .status(HttpStatus.CREATED)
//                       .statusCode(HttpStatus.CREATED.value())
//                       .build()
//       );
//    }
//    @GetMapping
//    public ResponseEntity<HttpResponse> confirmPassengerAccount(@RequestParam("token") String token){
//      Boolean isSuccessful = passengerService.verifyToken(token);
//       return ResponseEntity.ok().body(
//               HttpResponse.builder()
//                       .timeStamp(LocalDateTime.now().toString())
//                       .data(Map.of("success", isSuccessful))
//                       .message("Account Verified")
//                       .status(HttpStatus.OK)
//                       .statusCode(HttpStatus.OK.value())
//                       .build()
//       );
//    }

}
