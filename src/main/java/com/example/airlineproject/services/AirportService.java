package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;

public interface AirportService {
    Airport addAirport(Airport airport);
    Airport getAirportByCode(String code);
}
