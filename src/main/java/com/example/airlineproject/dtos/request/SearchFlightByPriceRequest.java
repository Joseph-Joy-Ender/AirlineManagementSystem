package com.example.airlineproject.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class SearchFlightByPriceRequest {
    private BigDecimal price;

}
