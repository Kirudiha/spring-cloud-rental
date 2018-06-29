package com.example.rental.rentalservice.v3;

import com.example.rental.rentalservice.dto.PriceRequest;
import com.example.rental.rentalservice.dto.PriceResponse;
import com.example.rental.rentalservice.dto.RentalChargesResponse;
import com.example.rental.rentalservice.v3.feign.PricingClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(path = "/v3")
public class RentalControllerV3 {

    private final PricingClient pricingClient;

    public RentalControllerV3(PricingClient pricingClient) {
        this.pricingClient = pricingClient;
    }

    @RequestMapping(path = "/rentals/{id}/charges", method = RequestMethod.GET)
    public ResponseEntity getPossibleCharges(@PathVariable("id") String id) {

        ZonedDateTime startTime = ZonedDateTime.now();
        ZonedDateTime endTime = startTime.plus(2, ChronoUnit.DAYS);
        PriceResponse response = pricingClient.getPriceAmount(new PriceRequest("vip", startTime, endTime));
        return new ResponseEntity<>(new RentalChargesResponse(response.getPrice()), HttpStatus.OK);
    }
}
