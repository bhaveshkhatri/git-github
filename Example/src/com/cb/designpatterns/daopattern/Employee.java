package com.cb.designpatterns.daopattern;

public class Employee {

	private String eName;
	private int id;
	
	public Employee(String eName, int id) {
		this.eName = eName;
		this.id = id;
	}
	
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
