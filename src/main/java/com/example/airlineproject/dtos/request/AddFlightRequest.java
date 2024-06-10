package com.example.airlineproject.dtos.request;

import com.example.airlineproject.data.models.Airline;
import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.models.FlightType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
public class AddFlightRequest {
    private String flightNumber;
    private String departureName;
    private String arrivalName;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate departureDate;
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime departureTime;
    private Airline airline;
    private FlightType flightType;
    private BigDecimal price;
}
