package com.example.airlineproject.services;

import com.example.airlineproject.data.models.Airport;
import com.example.airlineproject.data.models.Flight;
import com.example.airlineproject.data.repositories.FlightRepository;
import com.example.airlineproject.dtos.request.AddFlightRequest;
import com.example.airlineproject.dtos.request.SearchFlightByDestinationRequest;
import com.example.airlineproject.dtos.response.AddFlightResponse;
import com.example.airlineproject.dtos.response.FlightResponse;
import com.example.airlineproject.exceptions.DuplicateFlightException;
import com.example.airlineproject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigInteger.ONE;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService{

    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private final FlightRepository flightRepository;

    private final AirportService airportService;

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public AddFlightResponse addFlight(AddFlightRequest flightRequest) throws DuplicateFlightException {
        if (flightRepository.existsByFlightNumber(flightRequest.getFlightNumber())){
            throw new DuplicateFlightException(GenerateApiResponse.FLIGHT_WITH_THE_SAME_FIGHT_NUMBER_ALREADY_EXISTS);
        }

          Airport departure = airportService.getAirportByName(flightRequest.getDepartureName());
          Airport arrival = airportService.getAirportByName(flightRequest.getArrivalName());

          Flight flight = mapper.map(flightRequest, Flight.class);
          flight.setDepartureAirport(departure);
          flight.setArrivalAirport(arrival);
          flightRepository.save(flight);
          AddFlightResponse flightResponse = new AddFlightResponse();
          flightResponse.setMessage("Flight added successfully");
          return flightResponse;
    }

    @Override
    public List<FlightResponse> viewAllFlights(int page, int size) {
        Page<Flight> flightPage = flightRepository.findAll(createPageRequest(page, size));
        return flightPage.getContent()
                .stream()
                .map(flight -> mapper.map(flight, FlightResponse.class))
                .toList();
    }

    @Override
    public List<Flight> searchFlightByDestination(SearchFlightByDestinationRequest flightRequest) {
        Airport arrivalAirport = airportService.searchAirportByCode(flightRequest.getArrivalAirport());
        Airport departureAirport = airportService.searchAirportByCode(flightRequest.getDepartureAirport());
        return flightRepository.searchFlightsByArrivalAirportAndDepartureAirport(arrivalAirport, departureAirport);
    }

    @Override
    public List<Flight> searchFlightsByPrice(BigDecimal price) {
        return flightRepository.searchFlightsByPrice(price);
    }


    private static PageRequest createPageRequest(int page, int size) {
            if (page < DEFAULT_PAGE_NUMBER) page = DEFAULT_PAGE_NUMBER;
            if (size < ONE.intValue()) size = DEFAULT_PAGE_SIZE;
            page = page - ONE.intValue();
            return PageRequest.of(page, size);
    }


}
