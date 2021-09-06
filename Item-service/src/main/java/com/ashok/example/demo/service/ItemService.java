package com.ashok.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.example.demo.model.Item;
import com.ashok.example.demo.payload.SaveItemRequest;
import com.ashok.example.demo.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item saveItem(SaveItemRequest request) {
		Item item = new Item();
		item.setName(request.getName());
		item.setCategory(request.getCategory());
		item.setSubCategory(request.getSubCategory());
		item.setQuantity(request.getQuantity());
		
		if(request.getId() == null) {//new entity
			Long id = getNextId(itemRepository.getMaxId());
			item.setId(id);
		}
		return itemRepository.save(item);

	}

	public Item getItem(Long itemId) {
		return itemRepository.findById(itemId).get();

	}

	public List<Item> getItem() {
		return itemRepository.findAll();

	}
	
	private synchronized Long getNextId(Long currentId) {
		if(currentId == null) {
			return Long.valueOf(0);
		}
		return currentId + 1;
	}

}