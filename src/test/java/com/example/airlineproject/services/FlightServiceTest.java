package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Flight;
import com.example.airlineproject.data.models.FlightType;
import com.example.airlineproject.dtos.request.AddFlightRequest;
import com.example.airlineproject.dtos.request.SearchFlightByDestinationRequest;
import com.example.airlineproject.dtos.response.AddFlightResponse;
import com.example.airlineproject.dtos.response.FlightResponse;
import com.example.airlineproject.exceptions.DuplicateFlightException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.example.airlineproject.data.models.Airline.ArikAir;
import static com.example.airlineproject.data.models.Airline.DANA_AIR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@Slf4j
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;


    @Test
    public void testThatFlightCanBeAdded() throws DuplicateFlightException {
        AddFlightRequest flightRequest = new AddFlightRequest();

        flightRequest.setFlightNumber("ABC123EJ");
        flightRequest.setDepartureDate(LocalDate.of(2023, 10, 6));
        flightRequest.setDepartureTime(LocalTime.of(12, 45, 40));
        flightRequest.setDeparture("ABV");
        flightRequest.setArrival("LOS");
        flightRequest.setAirline(ArikAir);
        flightRequest.setFlightType(FlightType.ECONOMY);
        flightRequest.setPrice(BigDecimal.valueOf(100000));

        AddFlightResponse flightResponse = flightService.addFlight(flightRequest);
        assertThat(flightResponse).isNotNull();
        assertThat("ABC123EJ").isEqualTo(flightRequest.getFlightNumber());
    }

    @Test
    public void testThatMoreFlightsCanBeAdded() throws DuplicateFlightException {
        AddFlightRequest flightRequest = new AddFlightRequest();

        flightRequest.setFlightNumber("ABZ223ET");
        flightRequest.setDepartureDate(LocalDate.of(2023, 11, 7));
        flightRequest.setDepartureTime(LocalTime.of(3, 50, 45));
        flightRequest.setDeparture("ABV");
        flightRequest.setArrival("BNI");
        flightRequest.setAirline(ArikAir);
        flightRequest.setFlightType(FlightType.ECONOMY);
        flightRequest.setPrice(BigDecimal.valueOf(100000));

        AddFlightResponse flightResponse = flightService.addFlight(flightRequest);
        assertThat(flightResponse).isNotNull();
    }

    @Test
    public void testThatTheSameFlightCannotBeAddedTwice() throws DuplicateFlightException {
        AddFlightRequest flightRequest = new AddFlightRequest();

        flightRequest.setFlightNumber("ABC123ER");
        flightRequest.setDeparture("PHC");
        flightRequest.setArrival("IBA");
        flightRequest.setDepartureDate(LocalDate.of(2024, 1, 5));
        flightRequest.setDepartureTime(LocalTime.of(2, 40, 30));
        flightRequest.setAirline(DANA_AIR);
        flightRequest.setFlightType(FlightType.FIRSTCLASS);
        flightRequest.setPrice(BigDecimal.valueOf(200000));

        AddFlightResponse flightResponse = flightService.addFlight(flightRequest);
        assertThat(flightResponse).isNotNull();
        assertThatExceptionOfType(DuplicateFlightException.class).isThrownBy(()->flightService.addFlight(flightRequest));
    }

    @Test
    public void testThatAllFlightsCanBeViewed(){
        List<FlightResponse> allFlights = flightService.viewAllFlights(1, 5);
        log.info("All flights -> {}", allFlights);
        assertThat(allFlights).hasSize(3);
    }

    @Test
    public void testThatFlightCanBeSearchedFor(){
        SearchFlightByDestinationRequest flightRequest = new SearchFlightByDestinationRequest();

//        Airport departureAirport = new Airport();
//        departureAirport.setCode("ABV");
//        departureAirport.setName("Nnamdi Azikiwe International Airport");
//        departureAirport.setLocation("Abuja, Federal Capital Territory\n");
//
//        Airport arrivalAirport = new Airport();
//        arrivalAirport.setCode("IBA");
//        departureAirport.setName("Ibadan Airport");
//        departureAirport.setLocation("Ibadan, Oyo State");

        flightRequest.setDepartureAirport("ABV");
        flightRequest.setArrivalAirport("IBA");
        List<Flight> searchFlights = flightService.searchFlightByDestination(flightRequest);
        log.info("Searched flight :: {}", searchFlights);
        assertThat(searchFlights).hasSize(2);
    }

    @Test
    public void testThatFlightsCanBeSearchedByPrice(){
        BigDecimal price = BigDecimal.valueOf(100000.00);
        List<Flight> searchFlightByPrice = flightService.searchFlightsByPrice(price);
        assertThat(searchFlightByPrice).hasSize(2);
    }

//    @Test
//    public void testThatFlightCanBeCancelled(){
//        //TODO
//        //FIRST WE NEED TO FIND THE FLIGHT BY ID OR FLIGHT NUMBER
//        //SECOND CHECK IF THE FLIGHT EXIST
//
//    }

}
