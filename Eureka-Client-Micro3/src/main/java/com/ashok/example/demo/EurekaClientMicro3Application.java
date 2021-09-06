package com.ashok.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientMicro3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientMicro3Application.class, args);
	}

}
