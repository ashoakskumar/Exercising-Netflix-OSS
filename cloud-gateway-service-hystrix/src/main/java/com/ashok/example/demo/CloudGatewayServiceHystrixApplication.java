package com.ashok.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@EnableHystrix
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGatewayServiceHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServiceHystrixApplication.class, args);
	}

}
