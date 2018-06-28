package com.example.rental.rentalservice.v1;

import com.example.rental.rentalservice.dto.PriceRequest;
import com.example.rental.rentalservice.dto.PriceResponse;
import com.example.rental.rentalservice.dto.RentalChargesResponse;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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
@RequestMapping(path = "/v1")
public class RentalControllerV1 {

    private final RestTemplate restTemplate;
    private final EurekaClient eurekaClient;

    public RentalControllerV1(EurekaClient eurekaClient, RestTemplate restTemplate) {
        this.eurekaClient = eurekaClient;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/rentals/{id}/charges", method = RequestMethod.GET)
    public ResponseEntity getPossibleCharges(@PathVariable("id") String id) {

        InstanceInfo instance = eurekaClient.getNextServerFromEureka("pricing-service", false);
        ZonedDateTime startTime = ZonedDateTime.now();
        ZonedDateTime endTime = startTime.plus(2, ChronoUnit.DAYS);
        HttpEntity<PriceRequest> request = new HttpEntity<>(
                new PriceRequest("vip", startTime, endTime)
        );
        PriceResponse response = restTemplate.postForObject(instance.getHomePageUrl() + "/v1/prices", request, PriceResponse.class);
        return new ResponseEntity<>(new RentalChargesResponse(response.getPrice()), HttpStatus.OK);
    }

}
