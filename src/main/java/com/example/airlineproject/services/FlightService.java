package com.example.airlineproject.services;

import com.example.airlineproject.dtos.request.AddFlightRequest;
import com.example.airlineproject.dtos.response.AddFlightResponse;
import com.example.airlineproject.dtos.response.FlightResponse;
import com.example.airlineproject.exceptions.DuplicateFlightException;

import java.util.List;

public interface FlightService {


    AddFlightResponse addFlight(AddFlightRequest flightRequest) throws DuplicateFlightException;

    List<FlightResponse> viewAllFlights(int page, int size);
}
