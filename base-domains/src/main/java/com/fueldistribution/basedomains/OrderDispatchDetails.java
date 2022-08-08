package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrdeDispatchDetails")
public class OrderDispatchDetails{

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue
	int id;
	String refrenceNo;
	String status;
	int vehicleNo;
	
	public OrderDispatchDetails() {}
	
	public OrderDispatchDetails(int id, String refrenceNo, String status, int vehicleNo) {
		super();
		this.id = id;
		this.refrenceNo = refrenceNo;
		this.status = status;
		this.vehicleNo = vehicleNo;
	}

	public OrderDispatchDetails(String refrenceNo, String status, int vehicleNo) {
		super();
		this.refrenceNo = refrenceNo;
		this.status = status;
		this.vehicleNo = vehicleNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	
	
	
}

