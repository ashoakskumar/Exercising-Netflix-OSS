package com.ashok.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.example.demo.model.Order;
import com.ashok.example.demo.payload.CreateOrderRequest;
import com.ashok.example.demo.payload.CustomerResponsePayload;
import com.ashok.example.demo.payload.GetItemResponse;
import com.ashok.example.demo.repository.OrderRepository;
import com.ashok.example.demo.util.RestUtil;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestUtil RestUtil;
	
	public Order createOrder(CreateOrderRequest request) {
		Order order = new Order();
		
		//CustomerResponsePayload customerDetails = RestUtil.getCustomerDetailsByDiscoveryClient(request.getCustomerId()) ;
		CustomerResponsePayload customerDetails = RestUtil.getCustomerDetailsByRibbonBackedClient(request.getCustomerId()) ;
		
		order.setCustomerName(customerDetails.getName());
		order.setCustomerPhone(customerDetails.getPhone());
		
		//GetItemResponse itemDetails = RestUtilgetItemDetailsByDiscoveryClient(request.getItemId());
		GetItemResponse itemDetails = RestUtil.getItemDetailsByRibbonBackedClient(request.getItemId());
		com.ashok.example.demo.payload.Item item = itemDetails.getItems().get(0);
		
		order.setItemName(item.getName());
		order.setItemCategory(item.getCategory());
		order.setItemSubcategory(item.getSubCategory());
		order.setQuantity(item.getQuantity());
		
		order.setCreationDate(LocalDateTime.now());
		Long id = getNextId(orderRepository.getMaxId());
		order.setId(id);
		
		return orderRepository.save(order);
	}
	
	public Order getOrder(Long id) {
		return orderRepository.findById(id).get();
	}
	
	public List<Order> getOrder() {
		return orderRepository.findAll();
	}
	
	private synchronized Long getNextId(Long currentId) {
		if(currentId == null) {
			return Long.valueOf(0);
		}
		return currentId + 1;
	}

}
