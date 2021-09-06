package com.ashok.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondController {

	@GetMapping("/message")
	public String message() {
		return "Hello spring cloud gateway in second service";
	}
	@GetMapping("/message2")
	public String test2(@RequestHeader("second-request")String header) {
		return "Hello spring cloud gateway in first service with header - " + header;
	}
}
