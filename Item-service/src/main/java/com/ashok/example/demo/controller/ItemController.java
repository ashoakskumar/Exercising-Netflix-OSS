package com.ashok.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.demo.data.converter.ItemDataConverter;
import com.ashok.example.demo.payload.GetItemResponse;
import com.ashok.example.demo.payload.SaveItemRequest;
import com.ashok.example.demo.payload.SaveItemResponse;
import com.ashok.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService service;
	
	@Autowired
	private ItemDataConverter converter;
	
	//@Value("${item.service.message}")
	private String message;
	
	@Autowired
	private HttpServletRequest requestContext ;
	
	@GetMapping
	public GetItemResponse getItem() {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		List<com.ashok.example.demo.model.Item> itemEntityList =  service.getItem();
		return converter.convert(itemEntityList);
	}
	
	@GetMapping("{id}")
	public GetItemResponse getItem(@PathVariable(value = "id") Long itemId) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		com.ashok.example.demo.model.Item item =  service.getItem(itemId);
		return converter.convert(Arrays.asList(item));
	}
	
	@PostMapping()
	public SaveItemResponse saveItem(@RequestBody SaveItemRequest payload) {
		logger.info("service call started for transaction id : " + requestContext.getHeader("trx-id"));
		com.ashok.example.demo.model.Item item =  service.saveItem(payload);
		
		SaveItemResponse response = new SaveItemResponse();
		response.setMessage("item saved successfully");
		response.setId(item.getId());
		return response;
	}
	
	@GetMapping("ping")
	public String ping() {
		return "message";
	}

}
