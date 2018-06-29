package com.example.rental.rentalservice.v2;

import com.example.rental.rentalservice.dto.PriceRequest;
import com.example.rental.rentalservice.dto.PriceResponse;
import com.example.rental.rentalservice.dto.RentalChargesResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(path = "/v2")
public class RentalControllerV2 {
    protected String serviceUrl = "http://PRICING-SERVICE";

    private final RestTemplate restTemplate;

    public RentalControllerV2(@Qualifier("ribbon-template") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/rentals/{id}/charges", method = RequestMethod.GET)
    public ResponseEntity getPossibleCharges(@PathVariable("id") String id) {

        ZonedDateTime startTime = ZonedDateTime.now();
        ZonedDateTime endTime = startTime.plus(2, ChronoUnit.DAYS);
        HttpEntity<PriceRequest> request = new HttpEntity<>(
                new PriceRequest("vip", startTime, endTime)
        );
        PriceResponse response = restTemplate.postForObject(serviceUrl + "/v1/prices", request, PriceResponse.class);
        return new ResponseEntity<>(new RentalChargesResponse(response.getPrice()), HttpStatus.OK);
    }
}
