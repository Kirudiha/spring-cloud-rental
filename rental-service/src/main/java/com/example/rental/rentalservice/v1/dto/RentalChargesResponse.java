package com.example.rental.rentalservice.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RentalChargesResponse {
    private final BigDecimal price;

    @JsonCreator
    public RentalChargesResponse(@JsonProperty(required = true) BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
