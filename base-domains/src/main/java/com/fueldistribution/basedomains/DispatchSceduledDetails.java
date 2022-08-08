package com.fueldistribution.basedomains;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DispatchScheduleDetails")
public class DispatchSceduledDetails {

	@Id
	@GeneratedValue
	int id;
	String referenceNo;
	int vehicleNo;
	Date scheduledDate;
	String driverName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	String status;
	
	public DispatchSceduledDetails() {}
	
	public DispatchSceduledDetails(String referenceNo, int vehicleNo, Date scheduledDate, String driverName) {
		super();
		this.referenceNo = referenceNo;
		this.vehicleNo = vehicleNo;
		this.scheduledDate = scheduledDate;
		this.driverName = driverName;
	}

	public DispatchSceduledDetails(int vehicleNo, Date scheduledDate, String driverName) {
		super();
		this.vehicleNo = vehicleNo;
		this.scheduledDate = scheduledDate;
		this.driverName = driverName;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date date) {
		this.scheduledDate = date;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	
	
}
