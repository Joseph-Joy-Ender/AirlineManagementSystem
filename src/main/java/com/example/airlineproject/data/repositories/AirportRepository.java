package com.example.airlineproject.data.repositories;

import com.example.airlineproject.data.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
//    Airport findAirportByCodeContainsIgnoreCase(String code);
    Airport getAirportByCode(String code);
    Airport getAirportByName(String airportName);
    Airport searchAirportByCode(String code);

}
