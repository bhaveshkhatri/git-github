package org.cb.practice.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class TwoWheeler extends Vehicle {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
