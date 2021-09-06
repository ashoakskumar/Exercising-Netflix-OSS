package com.ashok.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class HystrixController {

	@GetMapping("/message")
	public String test() {
		return "Hello ! Spring gateway used in hystrix fallback service";
	}
}
