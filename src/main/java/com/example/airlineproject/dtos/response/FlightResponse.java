package com.example.airlineproject.dtos.response;

import com.example.airlineproject.data.models.Airline;
import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.models.FlightType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class FlightResponse {

    private Long id;
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Airline airline;
    private BigDecimal price;
    private FlightType flightType;
}
