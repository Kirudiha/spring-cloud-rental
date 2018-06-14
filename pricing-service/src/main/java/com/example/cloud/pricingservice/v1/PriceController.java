package com.example.cloud.pricingservice.api.v1;

import com.example.cloud.pricingservice.services.PriceCalculator;
import com.example.cloud.pricingservice.v1.dto.PriceRequest;
import com.example.cloud.pricingservice.v1.dto.PriceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class PriceController {
    private final PriceCalculator priceCalculator;

    public PriceController(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    @RequestMapping(path = "/prices", method = RequestMethod.POST)
    public ResponseEntity<PriceResponse> getPriceAmount(@RequestBody PriceRequest priceRequest) {

        return new ResponseEntity<>(
                new PriceResponse(priceCalculator.calculatePrice(priceRequest.getStart(), priceRequest.getEnd(), priceRequest.getPlan())),
                HttpStatus.OK);
    }

}
