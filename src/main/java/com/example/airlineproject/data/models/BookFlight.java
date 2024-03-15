package com.example.airlineproject.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class BookFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locationTo;
    private String locationFrom;
    private String flightName;
    private BigDecimal amount;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private FlightType flightType;
    private LocalDateTime dateOfDeparture;
    private LocalDateTime returningDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
