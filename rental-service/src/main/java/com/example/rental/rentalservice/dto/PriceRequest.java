package com.example.rental.rentalservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class PriceRequest {
    private final String plan;
    private final String start;
    private final String end;

    @JsonCreator
    public PriceRequest(
            @JsonProperty(required = true, value = "plan") String plan,
            @JsonProperty(required = true, value = "start") ZonedDateTime start,
            @JsonProperty(required = true, value = "end") ZonedDateTime end) {
        this.plan = plan;
        this.start = ISO_DATE_TIME.format(start);
        this.end = ISO_DATE_TIME.format(end);
    }

    public String getPlan() {
        return plan;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
