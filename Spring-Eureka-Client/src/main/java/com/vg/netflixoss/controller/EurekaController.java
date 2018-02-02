package com.vg.netflixoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.vg.netflixoss.*")
public class EurekaController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * http://localhost:8085/nodes/eureka-client
     * 
     * @param applicationName
     * @return
     */
    @RequestMapping("/nodes/{applicationName}")
    public List<ServiceInstance> getNodesByAppName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/nodes")
    public List<String> getAllNodes() {
        return this.discoveryClient.getServices();
    }
}
