package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;import jakarta.annotation.Generated;

@Entity
@Table(name="fuelDetails")
public class FuelDetails {

	@Id
	@GeneratedValue
	private int fuelId;
	private String fuelName;
	private int initialFuelAmount;
	private int reservedAmount;
	private int existingAmount;
	
	public int getReservedAmount() {
		return reservedAmount;
	}
	public void setReservedAmount(int reservedAmount) {
		this.reservedAmount = reservedAmount;
	}
	public int getExstingAmount() {
		return existingAmount;
	}
	public void setExstingAmount(int exstingAmount) {
		this.existingAmount = exstingAmount;
	}
	public FuelDetails() {
		
	}
	public FuelDetails(String fuelName, int initialFuelAmount,int reservedAmount,int existingAmount) {
		super();
		this.fuelName = fuelName;
		this.initialFuelAmount = initialFuelAmount;
		this.reservedAmount = reservedAmount;
		this.existingAmount = existingAmount;
	}
	public FuelDetails(int fuelId, String fuelName, int initialFuelAmount,int reservedAmount,int existingAmount) {
		super();
		this.fuelId = fuelId;
		this.fuelName = fuelName;
		this.initialFuelAmount = initialFuelAmount;
		this.reservedAmount = reservedAmount;
		this.existingAmount = existingAmount;
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
