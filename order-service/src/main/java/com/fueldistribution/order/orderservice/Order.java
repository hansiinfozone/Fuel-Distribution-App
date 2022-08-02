package com.fueldistribution.order.orderservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderDetails")
public class Order {

	@Id
	@GeneratedValue
	private Integer referenceNumber;
	private int gasStationId;
	private String gasStationName;
	private String typeOfFuel;
	private int capacityInLitres;
	
	public Order() {
		
	}
	
	public Order( Integer referenceNumber, int gasStationId, String gasStationName, String typeOfFuel,
			int capacityInLitres) {
		
		this.referenceNumber = referenceNumber;
		this.gasStationId = gasStationId;
		this.gasStationName = gasStationName;
		this.typeOfFuel = typeOfFuel;
		this.capacityInLitres = capacityInLitres;
	}
	
	
	
	public Order( int gasStationId, String gasStationName, String typeOfFuel,
			int capacityInLitres) {
		this.gasStationId = gasStationId;
		this.gasStationName = gasStationName;
		this.typeOfFuel = typeOfFuel;
		this.capacityInLitres = capacityInLitres;
	}



	public Integer getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(Integer referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public int getGasStationId() {
		return gasStationId;
	}
	public void setGasStationId(int gasStationId) {
		this.gasStationId = gasStationId;
	}
	public String getGasStationName() {
		return gasStationName;
	}
	public void setGasStationName(String gasStationName) {
		this.gasStationName = gasStationName;
	}
	public String getTypeOfFuel() {
		return typeOfFuel;
	}
	public void setTypeOfFuel(String typeOfFuel) {
		this.typeOfFuel = typeOfFuel;
	}
	public int getCapacityInLitres() {
		return capacityInLitres;
	}
	public void setCapacityInLitres(int capacityInLitres) {
		this.capacityInLitres = capacityInLitres;
	}
	
	
	
}
