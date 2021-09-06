package com.ashok.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.data.converter.CustomerDataConverter;
import com.ashok.example.demo.model.Customer;
import com.ashok.example.demo.payload.CustomerRequestPayload;
import com.ashok.example.demo.payload.CustomerResponsePayload;
import com.ashok.example.demo.service.CustomerService;

@RefreshScope
@RestController
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerDataConverter converter;
	
	/*
	 * @Value("${customer.service.message}") private String message;
	 */
	
	@Autowired
	private HttpServletRequest requestContext ;
	
	@GetMapping
	public List<CustomerResponsePayload> getCustomer() {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		List<Customer> customerEntity =  service.getCustomer();
		return converter.convert(customerEntity);
	}
	
	@GetMapping("{id}")
	public CustomerResponsePayload getCustomer(@PathVariable(value = "id") Long customerId) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		Customer customerEntity =  service.getCustomer(customerId);
		return converter.convert(customerEntity);
	}
	
	@PostMapping()
	public CustomerResponsePayload saveCustomer(@RequestBody CustomerRequestPayload payload) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		Customer customerEntity =  service.saveCustomer(payload);
		return converter.convert(customerEntity);
	}
	
	@GetMapping("ping")
	public String ping() {
		return "message";
	}
	
	

}