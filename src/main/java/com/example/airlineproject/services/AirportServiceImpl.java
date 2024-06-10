package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.repositories.AirportRepository;
import com.example.airlineproject.dtos.request.AddAirportRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService{

    private final AirportRepository airportRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Airport addAirport(AddAirportRequest airportRequest) {
        Airport airport = mapper.map(airportRequest, Airport.class);
        return airportRepository.save(airport);
    }

    @Override
    public Airport getAirportByCode(String code) {
        return airportRepository.getAirportByCode(code);
    }

    @Override
    public Airport getAirportByName(String airportName) {
        return airportRepository.getAirportByName(airportName);
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport searchAirportByCode(String airportCode) {
        return airportRepository.searchAirportByCode(airportCode);
    }
}
