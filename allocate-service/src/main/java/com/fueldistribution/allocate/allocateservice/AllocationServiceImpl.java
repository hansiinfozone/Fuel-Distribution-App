package com.fueldistribution.allocate.allocateservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.FuelDetails;

@Service
public class AllocationServiceImpl implements AllocationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationServiceImpl.class);

	@Autowired
	AllocationRepository allocationRepository;

	public boolean allocateFuel(String fuelType, int requestedFuelAmount) {
		boolean isallocateFuel = false;

		FuelDetails fuelDetails = allocationRepository.getExistingAmountByFuelName(fuelType);
		LOGGER.info("inside allocate fuel service method");

		int existingFuelAmount = fuelDetails.getExstingAmount();
		int reservedAmount = fuelDetails.getReservedAmount();

		if (existingFuelAmount > requestedFuelAmount) {

			isallocateFuel = true;
			reservedAmount = reservedAmount + requestedFuelAmount;
			existingFuelAmount = existingFuelAmount - requestedFuelAmount;

			fuelDetails.setReservedAmount(reservedAmount);
			fuelDetails.setExstingAmount(existingFuelAmount);
			allocationRepository.save(fuelDetails);

		}
		return isallocateFuel;

	}

}
