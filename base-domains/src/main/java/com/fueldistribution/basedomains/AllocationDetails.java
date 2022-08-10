package com.fueldistribution.basedomains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allocationDetails")
public class AllocationDetails {

	@Id
	int fuelId;
	String refNo;
	String fuelName;
	int allocatedAmount;
	String allocatedStatus;
	String allocatedMessage;

	public AllocationDetails() {

	}

	public AllocationDetails(String refNo, String fuelName, int allocatedAmount, String allocatedStatus,
			String allocatedMessage) {
		super();
		this.refNo = refNo;
		this.fuelName = fuelName;
		this.allocatedAmount = allocatedAmount;
		this.allocatedStatus = allocatedStatus;
		this.allocatedMessage = allocatedMessage;
	}

	public AllocationDetails(String fuelName, int allocatedAmount, String allocatedStatus, String allocatedMessage) {
		super();
		this.fuelName = fuelName;
		this.allocatedAmount = allocatedAmount;
		this.allocatedStatus = allocatedStatus;
		this.allocatedMessage = allocatedMessage;

	}

	public int getFuelId() {
		return fuelId;
	}

	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	public int getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setAllocatedAmount(int allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}

	public String getAllocatedStatus() {
		return allocatedStatus;
	}

	public void setAllocatedStatus(String allocatedStatus) {
		this.allocatedStatus = allocatedStatus;
	}

	public String getAllocatedMessage() {
		return allocatedMessage;
	}

	public void setAllocatedMessage(String allocatedMessage) {
		this.allocatedMessage = allocatedMessage;
	}

}
