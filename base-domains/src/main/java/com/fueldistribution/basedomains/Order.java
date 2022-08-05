package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name="order_details")
public class Order {

	@Id
	private String referenceNumber;
	private int gasStationId;
	private String gasStationName;
	private String typeOfFuel;
	private int capacityInLitres;
	private String status;
	private String Message;
	
	public Order() {
		
	}
	
	public Order( String referenceNumber, int gasStationId, String gasStationName, String typeOfFuel,
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



	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
