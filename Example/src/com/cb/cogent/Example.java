package com.cb.cogent;

import java.io.Serializable;

public class Example implements Serializable {
	
	private String street;
	private String country;
	private String state;
	private transient String empAddress;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "Example [street=" + street + ", country=" + country
				+ ", state=" + state + ", empAddress=" + empAddress + "]";
	}
	
	
}
