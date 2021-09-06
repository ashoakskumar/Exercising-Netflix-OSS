package com.ashok.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("micro2")
public class MicroController2 {
	@RequestMapping("name")
	   public String getMicroserviceName()
	   {
	        return "micro2";
	   }
}
