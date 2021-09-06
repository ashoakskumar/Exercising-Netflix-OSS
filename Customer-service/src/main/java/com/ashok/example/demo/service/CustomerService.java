package com.ashok.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.example.demo.model.Customer;
import com.ashok.example.demo.payload.CustomerRequestPayload;
import com.ashok.example.demo.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	public Customer saveCustomer(CustomerRequestPayload request) {
		Customer customerEntity = new Customer();
		customerEntity.setName(request.getName());
		customerEntity.setPassword(request.getPassword());
		customerEntity.setPhone(request.getPhone());
		
		if(request.getId() == 0) {//new entity
			Long id = getNextId(repository.getMaxId());
			customerEntity.setId(id);
		}
		return repository.save(customerEntity);
	}

	public void deleteCustomer(CustomerRequestPayload request) {
		Customer customerEntity = new Customer();
		customerEntity.setId(request.getId());
		repository.delete(customerEntity);
	}

	public Customer getCustomer(Long id) {
		return repository.getOne(id);

	}

	public List<Customer> getCustomer() {
		return repository.findAll();
	}
	
	private synchronized Long getNextId(Long currentId) {
		if(currentId == null) {
			return Long.valueOf(0);
		}
		return currentId + 1;
		
	}
	
	
}
