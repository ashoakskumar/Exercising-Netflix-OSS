package com.ashok.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("micro1")
public class Micro1Controller {
	@RequestMapping("name")
	   public String getMicroserviceName()
	   {
	       String micro2Response = new
	   RestTemplate().postForObject("http://localhost:8081/micro2/name",
	   null, String.class);
	       return "micro1" + " : " + micro2Response;
	   }
}
