package com.ashok.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/micro3")
public class MicroController3 {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/name")
	public String getMicroserviceName() {
		List<ServiceInstance> list =
                discoveryClient.getInstances("Micro2");
		ServiceInstance service2 = list.get(0);
		URI micro2URI = service2.getUri();
		String micro2Response = new
		          RestTemplate().postForObject(micro2URI +
		          "/micro2/name", null, String.class);
		return "micro3 : " + micro2Response;
	}
}
