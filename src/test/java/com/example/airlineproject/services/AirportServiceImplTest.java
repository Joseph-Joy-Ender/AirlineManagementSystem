package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.repositories.AirportRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@Slf4j
class AirportServiceImplTest {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void testThatAirportCanBeAdded(){
        Airport airport = new Airport();
        airport.setCode("ABV");
        airport.setName("Nnamdi Azikiwe International Airport");
        airport.setLocation("Abuja, Federal Capital Territory");
        airportService.addAirport(airport);
        assertEquals(airportRepository.count(), 1);
    }
    @Test
    public void testThatAirportCanBeAddedTheSecondTime(){
        Airport airport = new Airport();
        airport.setCode("LOS");
        airport.setName("Murtala Muhammed International Airport");
        airport.setLocation("Ikeja, Lagos State");
        airportService.addAirport(airport);
        assertEquals(airportRepository.count(), 2);
    }
    @Test
    public void testThatAirportCanBeAddedTheThirdTime(){
        Airport airport = new Airport();
        airport.setCode("BNI");
        airport.setName("Benin Airport");
        airport.setLocation("Benin city");
        airportService.addAirport(airport);
        assertEquals(airportRepository.count(), 3);
    }
    @Test
    public void testThatAirportCanBeAddedTheFourthTime(){
        Airport airport = new Airport();
        airport.setCode("PHC");
        airport.setName("Port Harcourt International Airport");
        airport.setLocation("Omagwa, Rivers State");
        airportService.addAirport(airport);
        assertEquals(airportRepository.count(), 4);
    }
    @Test
    public void testThatAirportCanBeAddedTheFifthTime(){
        Airport airport = new Airport();
        airport.setCode("IBA");
        airport.setName("Ibadan Airport");
        airport.setLocation("Ibadan, Oyo State");
        airportService.addAirport(airport);
        assertEquals(airportRepository.count(), 5);
    }

    @Test
    public void testThatAirportCanBeGottenUsingTheCode(){
        String code = "IBA";
        Airport airport = airportService.getAirportByCode(code);
        log.info("Airport found :: {}", airport);
        assertThat(airport).isNotNull();

    }

}