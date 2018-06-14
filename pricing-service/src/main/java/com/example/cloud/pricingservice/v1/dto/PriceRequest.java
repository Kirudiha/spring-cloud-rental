package com.example.cloud.pricingservice.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public class PriceRequest {
    private final String plan;
    private final ZonedDateTime start;
    private final ZonedDateTime end;

    @JsonCreator
    public PriceRequest(
            @JsonProperty(required = true, value = "plan") String plan,
            @JsonProperty(required = true, value = "start") String start,
            @JsonProperty(required = true, value = "end") String end) {
        this.plan = plan;
        this.start = ZonedDateTime.from(ISO_DATE_TIME.parse(start));
        this.end = ZonedDateTime.from(ISO_DATE_TIME.parse(end));
    }

    public String getPlan() {
        return plan;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }
}
