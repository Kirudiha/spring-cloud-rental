package com.example.cloud.pricingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "pricing")
public class PlanConfig {

    private HashMap<String, BigDecimal> plan;

    public HashMap<String, BigDecimal> getPlan() {
        return plan;
    }

    public void setPlan(HashMap<String, BigDecimal> plan) {
        this.plan = plan;
    }

}