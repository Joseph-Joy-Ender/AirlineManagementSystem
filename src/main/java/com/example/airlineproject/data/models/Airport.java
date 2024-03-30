package com.example.airlineproject.data.models;

import lombok.Getter;

@Getter
public enum Airport {
    LOS("LOS", "Murtala Muhammed International Airports", "Ikeja Lagos State"),
    ABV("ABV", "Nnamdi Azikiwe Airports", "Abuja, Federal Capital Territory"),
    IBA("IBA", "Ibadan Airports", "Ibadan, Oyo State"),
    BNI("BNI", "Benin City Airports", "Benin City, Edo State"),
    PHC("PHC", "Port Harcourt International Airport", "Port Harcourt, Rivers State");

    private final String code;
    private final String name;
    private final String location;

    Airport(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
    }


}
