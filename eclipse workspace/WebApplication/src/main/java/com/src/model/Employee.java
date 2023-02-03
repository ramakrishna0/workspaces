package com.src.model;

public class Employee {
	private String id;
	private String name;
	private String pwd;
	private String age;
	private long mobile;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String id, String name, String pwd, String age, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	

}
