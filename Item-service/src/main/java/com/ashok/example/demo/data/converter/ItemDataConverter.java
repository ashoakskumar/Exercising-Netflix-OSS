package com.ashok.example.demo.data.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ashok.example.demo.model.Item;
import com.ashok.example.demo.payload.GetItemResponse;

@Component
public class ItemDataConverter {
	
	public GetItemResponse convert(List<Item> itemsEntities) {
		
		GetItemResponse response = new GetItemResponse();
		List<com.ashok.example.demo.payload.Item> items = new ArrayList<>();
		
		itemsEntities.forEach(itemEntity -> {
			com.ashok.example.demo.payload.Item item = new com.ashok.example.demo.payload.Item();
			item.setName(itemEntity.getName());
			item.setCategory(itemEntity.getCategory());
			item.setSubCategory(itemEntity.getSubCategory());
			item.setQuantity(itemEntity.getQuantity());
			items.add(item);
		});
		
		response.setItems(items);
		return response;
		
	}

}
