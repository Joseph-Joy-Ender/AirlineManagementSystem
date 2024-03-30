package com.example.airlineproject.controllers;

import com.example.airlineproject.data.models.FlightType;
import com.example.airlineproject.dtos.request.AddFlightRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.airlineproject.data.models.Airline.ArikAir;
import static com.example.airlineproject.data.models.Airport.ABV;
import static com.example.airlineproject.data.models.Airport.IBA;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testThatFlightCanBeAdded() throws Exception {
        AddFlightRequest flightRequest = new AddFlightRequest();

        flightRequest.setFlightNumber("ABD123EM");
        flightRequest.setDepartureAirport(ABV);
        flightRequest.setArrivalAirport(IBA);
        flightRequest.setDepartureDate(LocalDate.of(2024, 6, 1));
        flightRequest.setDepartureTime(LocalTime.of(7, 20, 30));
        flightRequest.setAirline(ArikAir);
        flightRequest.setFlightType(FlightType.BUSINESS);
        flightRequest.setPrice(BigDecimal.valueOf(170000));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/flight/addFlight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(flightRequest)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void testThatUserReadingListCanBeDisplayed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flight/viewAllFlights/1/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}
