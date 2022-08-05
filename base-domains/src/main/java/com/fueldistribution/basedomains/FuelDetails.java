package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fuelDetails")
public class FuelDetails {

	@Id
	private int fuelId;
	private String fuelName;
	private int initialFuelAmount;
	
	public FuelDetails() {
		
	}
	public FuelDetails(String fuelName, int initialFuelAmount) {
		super();
		this.fuelName = fuelName;
		this.initialFuelAmount = initialFuelAmount;
	}
	public FuelDetails(int fuelId, String fuelName, int initialFuelAmount) {
		super();
		this.fuelId = fuelId;
		this.fuelName = fuelName;
		this.initialFuelAmount = initialFuelAmount;
	}
	public int getFuelId() {
		return fuelId;
	}
	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}
	public String getFuelName() {
		return fuelName;
	}
	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}
	public int getInitialFuelAmount() {
		return initialFuelAmount;
	}
	public void setInitialFuelAmount(int initialFuelAmount) {
		this.initialFuelAmount = initialFuelAmount;
	}
	
	
	
	
}
