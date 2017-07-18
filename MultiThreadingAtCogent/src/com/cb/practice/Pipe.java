package com.cb.practice;

public class Pipe {
	
	String name;
	boolean available;
	
	public Pipe(String name) {
		this.name = name;
		available = true;
	}
	
	public void setAvailable(boolean value) {
		available = value;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public String getName() {
		return name;
	}

}
