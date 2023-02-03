package com.spring;

public class A{
	private B b;

	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside constructor A");
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	public void display() {
		System.out.println("A diplay");
		b.display();
	}
}
