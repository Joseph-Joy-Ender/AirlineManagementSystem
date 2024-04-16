package com.example.airlineproject.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true)
    private String flightNumber;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Airport departureAirport;

    @ManyToOne(cascade = {CascadeType.MERGE})
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
