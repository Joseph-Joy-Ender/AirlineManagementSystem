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
public class FlightServiceImplTest {

    @Autowired
    private FlightService flightService;


    @Test
    public void testThatFlightCanBeAdded() throws DuplicateFlightException {
        AddFlightRequest flightRequest = new AddFlightRequest();

        flightRequest.setFlightNumber("ABC123EJ");
        flightRequest.setDepartureDate(LocalDate.of(2023, 10, 6));
        flightRequest.setDepartureTime(LocalTime.of(12, 45, 40));
        flightRequest.setDepartureName("Nnamdi Azikiwe Airport");
        flightRequest.setArrivalName("Murtala Muhammed International Airport");
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
        flightRequest.setDepartureName("Nnamdi Azikiwe Airport");
        flightRequest.setArrivalName("Benin Airport");
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
        flightRequest.setDepartureName("Port Harcourt International Airport");
        flightRequest.setArrivalName("Ibadan Airport");
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
        flightRequest.setDepartureAirport("ABV");
        flightRequest.setArrivalAirport("LOS");
        List<Flight> searchFlights = flightService.searchFlightByDestination(flightRequest);
        log.info("Searched flight :: {}", searchFlights);
        assertThat(searchFlights).hasSize(1);
    }

    @Test
    public void testThatFlightCanBeSearchedForByAirport(){
        SearchFlightByDestinationRequest flightRequest = new SearchFlightByDestinationRequest();
        flightRequest.setDepartureAirport("ABV");
        flightRequest.setArrivalAirport("IBA");
        List<Flight> searchFlights = flightService.searchFlightByDestination(flightRequest);
//        log.info("Searched flight :: {}", searchFlights);
        assertThat(searchFlights).isNotNull();
    }

    @Test
    public void testThatFlightsCanBeSearchedByPrice(){
        BigDecimal price = BigDecimal.valueOf(100000.00);
        List<Flight> searchFlightByPrice = flightService.searchFlightsByPrice(price);
        assertThat(searchFlightByPrice).hasSize(2);
    }

    @Test
    public void testThatFlightCanBeBooked (){
        //TODO
        //FIRST WE NEED TO FIND THE FLIGHT BY ID OR FLIGHT NUMBER
        //SECOND CHECK IF THE FLIGHT EXIST

    }

}
