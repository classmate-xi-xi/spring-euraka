package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/c")
    public String c(){
        ServiceInstance serviceInstance =loadBalancerClient.choose("demo");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/c";
        return restTemplate.getForObject(url,String.class);
    }
}
