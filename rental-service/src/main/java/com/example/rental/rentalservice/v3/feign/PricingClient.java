package com.example.rental.rentalservice.v3.feign;

import com.example.rental.rentalservice.dto.PriceRequest;
import com.example.rental.rentalservice.dto.PriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pricing-service")
public interface PricingClient {

    @RequestMapping(path = "/v1/prices", method = RequestMethod.POST)
    PriceResponse getPriceAmount(@RequestBody PriceRequest priceRequest);
}