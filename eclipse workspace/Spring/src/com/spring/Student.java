package com.spring;

import java.util.Map;

public class Student {
	private int id;
	private String name;
	private Map<String, Address> addresses;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}	

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student(Map<String, Address> addresses) {
		super();
		this.addresses = addresses;
	}


	public Student(int id, String name, Map<String, Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}
	
	
}
