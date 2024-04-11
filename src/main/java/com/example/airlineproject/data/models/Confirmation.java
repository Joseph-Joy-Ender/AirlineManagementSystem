package com.example.airlineproject.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;
    @JoinColumn(nullable = false, name = "passenger_id")
    @OneToOne(targetEntity = Passenger.class, fetch = FetchType.EAGER)
    private Passenger passenger;

    public Confirmation(Passenger passenger){
        this.passenger = passenger;
        this.createdDate = LocalDateTime.now();
        this.token = UUID.randomUUID().toString();
    }
}

