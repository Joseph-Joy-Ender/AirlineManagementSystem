package com.example.airlineproject.data.repositories;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    boolean existsByFlightNumber(String flightNumber);
    List<Flight> searchFlightsByPrice(BigDecimal price);
    List<Flight> searchFlightsByArrivalAirportAndDepartureAirport(Airport airport, Airport departureAirport);
}
