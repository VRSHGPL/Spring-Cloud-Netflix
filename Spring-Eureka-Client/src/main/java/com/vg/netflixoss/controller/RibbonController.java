package com.vg.netflixoss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vg.netflixoss.service.RibbonService;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    /**
     * http://localhost:8085/ribbon/nodes
     * 
     * @return
     */
    @RequestMapping("/ribbon/nodes")
    public String getNodes() {
        return "Calling Eureka :: Node Details :" + ribbonService.getNodes();
    }
}
