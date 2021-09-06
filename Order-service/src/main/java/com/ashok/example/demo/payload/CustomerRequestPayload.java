package com.ashok.example.demo.payload;

public class CustomerRequestPayload {

	private String name;
	private long id;
	private String password;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CustomerRequestPayload [name=" + name + ", id=" + id + ", passeword=" + password + ", phone=" + phone
				+ "]";
	}
	
	
}
