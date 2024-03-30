package com.example.airlineproject.data.repositories;

import com.example.airlineproject.data.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Passenger, Long> {
    boolean existsByEmailAddress(String emailAddress);
}
