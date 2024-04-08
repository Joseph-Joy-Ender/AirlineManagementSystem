package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.repositories.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService{

    private final AirportRepository airportRepository;
    @Override
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport getAirportByCode(String code) {
        return airportRepository.getAirportByCode(code);
    }
}
