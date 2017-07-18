package org.cb.springpractice.model;

public class Circle {
	
	private String name;

	public String getName() {
		System.out.println("whoraaaa!!!");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter is called");
		throw(new RuntimeException());
	}

}
