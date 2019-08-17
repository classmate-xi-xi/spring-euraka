package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/c")
    public String c(){
        String s = "Server"+discoveryClient.getServices();
        return s;
    }
}
