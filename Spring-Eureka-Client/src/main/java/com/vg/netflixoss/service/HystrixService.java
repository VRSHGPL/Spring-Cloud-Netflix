package com.vg.netflixoss.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "getFallbackCustomer")
    public String getCustomer() {
        throw new RuntimeException("Simulating failure for Unavailable Service");
    }

    public String getFallbackCustomer() {
        return "Back Up Customer";
    }

}
