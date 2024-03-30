package com.example.airlineproject.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String flightNumber;

    @Enumerated(EnumType.STRING)
    private Airport departureAirport;

    @Enumerated(EnumType.STRING)
    private Airport arrivalAirport;

    private LocalDate departureDate;

    private LocalTime departureTime;

    @Enumerated(EnumType.STRING)
    private Airline airline;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Passenger passenger;
}
