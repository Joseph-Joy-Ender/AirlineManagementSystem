package com.example.airlineproject.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchFlightByDestinationRequest {

    private String departureAirport;
    private String arrivalAirport;

}
