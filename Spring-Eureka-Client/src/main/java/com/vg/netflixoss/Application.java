package com.vg.netflixoss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vg.netflixoss.service.HystrixService;

@RestController
@ComponentScan("com.vg.netflixoss.*")
@EnableHystrixDashboard
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableDiscoveryClient
public class Application {

    @Autowired
    private HystrixService hystrixService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "OK";
    }

}
