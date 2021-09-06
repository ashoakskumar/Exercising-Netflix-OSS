package com.ashok.example.demo.payload;

import javax.validation.constraints.NotNull;

public class SaveItemRequest {

	@NotNull
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String category;

	@NotNull
	private String subCategory;

	@NotNull
	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
