package com.ashok.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashok.example.demo.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query("SELECT MAX(i.id) FROM Item i")
	public Long getMaxId();

}
