package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.dtos.request.AddAirportRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
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

    @Test
    public void testThatAirportCanBeAdded(){
        AddAirportRequest addAirportRequest = new AddAirportRequest();
        addAirportRequest.setCode("BNI");
        addAirportRequest.setLocation("Benin city");
        addAirportRequest.setName("Benin Airport");
        Airport airport = airportService.addAirport(addAirportRequest);
        assertThat(airport).isNotNull();
    }
    @Test
    public void testThatAirportCanBeAdded2(){
        AddAirportRequest addAirportRequest = new AddAirportRequest();
        addAirportRequest.setCode("PHC");
        addAirportRequest.setLocation("Omagwa, Rivers State");
        addAirportRequest.setName("Port Harcourt International Airport");
        Airport airport = airportService.addAirport(addAirportRequest);
        assertThat(airport).isNotNull();
    }

    @Test
    public void testThatAirportCanBeAdded3(){
        AddAirportRequest addAirportRequest = new AddAirportRequest();
        addAirportRequest.setCode("IBA");
        addAirportRequest.setLocation("Ibadan, Oyo State");
        addAirportRequest.setName("Ibadan Airport");
        Airport airport = airportService.addAirport(addAirportRequest);
        assertThat(airport).isNotNull();
    }

    @Test
    public void testThatAirportCanBeSearchedByAirportCode(){
        String airportCode = "ABV";
        Airport airport = airportService.searchAirportByCode(airportCode);
        assertThat(airport).isNotNull();
        log.info("Searched airport :: {}", airport);
    }
}