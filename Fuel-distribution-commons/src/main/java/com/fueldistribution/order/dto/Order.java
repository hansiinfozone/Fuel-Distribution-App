package com.fueldistribution.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	
	private int orderReferenceNum;
	private int gasStatioinId;
	private String gasStationName;
	private String typeOfFuel;
	private double capacity;
	
	
	
	
	
}
