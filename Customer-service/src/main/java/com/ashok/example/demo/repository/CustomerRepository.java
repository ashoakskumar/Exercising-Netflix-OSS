package com.ashok.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashok.example.demo.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT MAX(x.id) FROM Customer x")
	public Long getMaxId();
}
