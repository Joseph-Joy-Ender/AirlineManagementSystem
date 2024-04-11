package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.dtos.request.AddAirportRequest;

public interface AirportService {
    Airport addAirport(AddAirportRequest addAirportRequest);
    Airport getAirportByCode(String code);
    Airport save(Airport airport);
}
