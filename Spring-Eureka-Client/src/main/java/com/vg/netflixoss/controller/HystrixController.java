package com.vg.netflixoss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixController {

    /**
     * on accessing /customer, http://application-host/hystrix.stream gives the stream
     * 
     * @return
     */

    @HystrixCommand(fallbackMethod = "getFallbackCustomer")
    @RequestMapping("/customer")
    public String getCustomer() {
        throw new RuntimeException("Simulating failure for Unavailable Service");
    }

    public String getFallbackCustomer() {
        return "Back Up Customer";
    }
}
