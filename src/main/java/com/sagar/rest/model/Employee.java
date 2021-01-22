package com.sagar.rest.model;

public class Employee {

	private Long id;

	private String name;

	private String address;

	private String dob;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + "]";
	}

	public Employee(Long id, String name, String address, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}
}
