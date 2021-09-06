package com.ashok.example.demo.model;

public class Student {

	private Integer id;
	private String name;
	private String level;
	private String country;
	
	public Student(Integer id, String name, String level, String country) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
