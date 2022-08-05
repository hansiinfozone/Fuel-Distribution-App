package com.fueldistribution.allocate.allocateservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationServiceImpl implements AllocationService{
	
	@Autowired
	AllocationRepository allocationRepository;

	public boolean allocateFuel(String fuelType, int requestedFuelAmount) {
		boolean isallocateFuel = true;
		
		
		
		return isallocateFuel;
		
		
	}


}
