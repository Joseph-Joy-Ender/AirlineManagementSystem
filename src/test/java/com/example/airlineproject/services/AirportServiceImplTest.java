package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.dtos.request.AddAirportRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AirportServiceImplTest {

    @Autowired
    private AirportService airportService;
    @Test
    void addAirport() {
        AddAirportRequest addAirportRequest = new AddAirportRequest();
        addAirportRequest.setCode("ABV");
        addAirportRequest.setLocation("Abuja, Federal Capital Territory");
        addAirportRequest.setName("Nnamdi Azikiwe Airport");
        Airport airport = airportService.addAirport(addAirportRequest);
        assertThat(airport).isNotNull();
    }

    @Test
    void addAirportAgain() {
        AddAirportRequest addAirportRequest = new AddAirportRequest();
        addAirportRequest.setCode("LOS");
        addAirportRequest.setLocation("Lagos state");
        addAirportRequest.setName("Murtala Muhammed International Airport");
        Airport airport = airportService.addAirport(addAirportRequest);
        assertThat(airport).isNotNull();


    }
}