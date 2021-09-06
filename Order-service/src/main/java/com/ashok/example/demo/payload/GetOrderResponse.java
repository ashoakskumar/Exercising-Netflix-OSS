package com.ashok.example.demo.payload;

import java.util.List;

public class GetOrderResponse {
	
	private List<OrderPayload> orders;

	public List<OrderPayload> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderPayload> orders) {
		this.orders = orders;
	}

}