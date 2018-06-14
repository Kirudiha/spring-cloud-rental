package com.example.cloud.pricingservice.v1;

import com.example.cloud.pricingservice.v1.dto.PriceRequest;
import com.example.cloud.pricingservice.v1.dto.PriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/v1")
public class PriceController {

    @RequestMapping(path = "/prices", method = RequestMethod.POST)
    public ResponseEntity<PriceResponse> getPriceAmount(@RequestBody PriceRequest priceRequest) {

        return new ResponseEntity<>(new PriceResponse(BigDecimal.ZERO), HttpStatus.OK);
    }

}
