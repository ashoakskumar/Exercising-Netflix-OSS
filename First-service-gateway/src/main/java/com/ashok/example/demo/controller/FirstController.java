package com.ashok.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class FirstController {

	@GetMapping("/message")
	public String test() {
		return "Hello spring cloud gateway in first service";
	}
	@GetMapping("/message2")
	public String test2(@RequestHeader("first-request")String header) {
		return "Hello spring cloud gateway in first service with header - " + header;
	}
}
