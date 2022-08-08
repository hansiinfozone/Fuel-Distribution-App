package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicleDetails")
public class VehicleDetails {

	@Id
	@GeneratedValue
	int id;
	String vehicleNo;
	String allocationStatus;
	String driverName;
	
	public VehicleDetails()
	{}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getAllocationStatus() {
		return allocationStatus;
	}
	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public VehicleDetails(int id, String vehicleNo, String allocationStatus, String driverName) {
		super();
		this.id = id;
		this.vehicleNo = vehicleNo;
		this.allocationStatus = allocationStatus;
		this.driverName = driverName;
	}

	public VehicleDetails(String vehicleNo, String allocationStatus, String driverName) {
		super();
		this.vehicleNo = vehicleNo;
		this.allocationStatus = allocationStatus;
		this.driverName = driverName;
	}
	
	
	
	
}
