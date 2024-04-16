package com.example.airlineproject.controller;

import com.example.airlineproject.data.models.Flight;
import com.example.airlineproject.dtos.request.AddFlightRequest;
import com.example.airlineproject.dtos.response.AddFlightResponse;
import com.example.airlineproject.dtos.response.FlightResponse;
import com.example.airlineproject.exceptions.DuplicateFlightException;
import com.example.airlineproject.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/api/v1/flight")
@CrossOrigin("*")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/addFlight")
    public ResponseEntity<AddFlightResponse> addFlight(@RequestBody AddFlightRequest flightRequest) throws DuplicateFlightException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(flightService.addFlight(flightRequest));
    }

    @GetMapping("/viewAllFlights/{page}/{size}")
    public ResponseEntity<List<FlightResponse>> viewAllFlights(@PathVariable int page, @PathVariable int size){
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.viewAllFlights(page, size));
    }

//    @GetMapping("/searchFlightByDestination")
//    public ResponseEntity<List<Flight>> searchFlightByDestination(@RequestBody SearchFlightByDestinationRequest destinationRequest){
//        return new ResponseEntity<>(flightService.searchFlightByDestination(destinationRequest), HttpStatus.OK);
//    }
    @GetMapping("/searchFlightByPrice/{price}")
    public ResponseEntity<List<Flight>> searchFlightByPrice(@PathVariable BigDecimal price){
        return new ResponseEntity<>(flightService.searchFlightsByPrice(price), HttpStatus.OK);
    }
}
