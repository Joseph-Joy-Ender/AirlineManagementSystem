package com.example.airlineproject.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private boolean isLocked = true;
    private LocalDateTime localDateTime;
}
