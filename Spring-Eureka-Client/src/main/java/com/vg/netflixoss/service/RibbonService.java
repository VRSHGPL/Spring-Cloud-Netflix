package com.vg.netflixoss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String getNodes() {
        return restTemplate.exchange("http://eureka-client/nodes", HttpMethod.GET, null, String.class).getBody();
    }
}
