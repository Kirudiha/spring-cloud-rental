package com.example.rental.rentalservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PriceResponse {
    private final BigDecimal price;

    @JsonCreator
    public PriceResponse(@JsonProperty(value = "price", required = true) BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
