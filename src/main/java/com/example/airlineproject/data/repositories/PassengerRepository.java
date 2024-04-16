package com.example.airlineproject.data.repositories;

import com.example.airlineproject.data.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    boolean existsByEmailAddress(String emailAddress);
    Passenger findByEmailAddressIgnoreCase(String emailAddress);
    Optional<Passenger> findByFullName(String fullName);
}
