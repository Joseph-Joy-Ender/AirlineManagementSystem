package com.example.airlineproject.dtos.request;

import com.example.airlineproject.data.models.Airport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchFlightRequest {

    private Airport departureAirport;
    private Airport arrivalAirport;

}
