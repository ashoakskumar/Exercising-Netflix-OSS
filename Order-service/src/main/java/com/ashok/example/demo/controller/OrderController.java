package com.ashok.example.demo.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.data.converter.OrderDataConverter;
import com.ashok.example.demo.model.Order;
import com.ashok.example.demo.payload.CreateOrderRequest;
import com.ashok.example.demo.payload.CreateOrderResponse;
import com.ashok.example.demo.payload.GetOrderResponse;
import com.ashok.example.demo.service.OrderService;

@RestController
@EnableDiscoveryClient
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderDataConverter converter;
	
	//@Value("${order.service.message}")
	private String message;
	
	@Autowired
	private HttpServletRequest requestContext ;
	
	@GetMapping
	public GetOrderResponse getOrder() {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		return converter.convert(service.getOrder());
	}
	
	@GetMapping("{id}")
	public GetOrderResponse getOrder(@PathVariable(value = "id") Long orderId) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		Order order = service.getOrder(orderId);
		return converter.convert(Arrays.asList(order));
	}
	
	@PostMapping()
	public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		Order order = service.createOrder(request);
		CreateOrderResponse response = new CreateOrderResponse();
		response.setMessage("order created successfully");
		response.setOrderId(order.getId());
		return response;
	}
	
	@GetMapping("ping")
	public String ping() {
		return "message";
	}

}
