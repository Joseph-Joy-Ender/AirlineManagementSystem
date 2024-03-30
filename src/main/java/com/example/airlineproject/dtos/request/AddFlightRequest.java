package com.example.airlineproject.dtos.request;

import com.example.airlineproject.data.models.Airline;
import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.models.FlightType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class AddFlightRequest {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Airline airline;
    private FlightType flightType;
    private BigDecimal price;
}
