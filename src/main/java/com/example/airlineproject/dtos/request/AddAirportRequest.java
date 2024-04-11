package com.example.airlineproject.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAirportRequest {
    private String code;
    private String name;
    private String location;

}
