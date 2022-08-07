package com.fueldistribution.allocate.allocateservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fueldistribution.basedomains.AllocationDetails;
import com.fueldistribution.basedomains.Order;
import com.fueldistribution.order.orderservice.OrderDetailsRepository;

@RestController
@RequestMapping(path="/allocation")
public class AllocationController {
	
	@Autowired
	private AllocationProducer allocationProducer;

	@Autowired
	private AllocationService allocationService;
	@Autowired
	private AllocationRepository allocationRepository;
	
	
	
	public AllocationController() {}
	public AllocationController(AllocationProducer allocationProducer) {
		this.allocationProducer=allocationProducer;
		
	}

	public AllocationController(AllocationService allocationService, AllocationRepository allocationRepository) {
		
		this.allocationService = allocationService;
		this.allocationRepository = allocationRepository;
	}

	public String allocateFuel(String refNo, String fuelType, int requestedFuelAmount) {
		
		String allocationStatusMesssage = null;
		boolean isAllocateFuel = allocationService.allocateFuel(fuelType,requestedFuelAmount);
		if(isAllocateFuel == true) {
			
			allocationStatusMesssage = "Fuel amount successfully allocated";
			AllocationDetails allocationDetails = new AllocationDetails();
			
			allocationDetails.setRefNo(refNo);
			allocationDetails.setFuelName(fuelType);
			allocationDetails.setAllocatedAmount(requestedFuelAmount);
			allocationDetails.setAllocatedStatus("ALLOCATED");
			allocationDetails.setAllocatedMessage(allocationStatusMesssage);
			allocationProducer.sendMessage(allocationDetails);
			saveAllocationDetails(allocationDetails);

		}
		else {
			AllocationDetails allocationDetails = new AllocationDetails();

			allocationStatusMesssage = "Allocation can not be done";
			allocationDetails.setRefNo(refNo);
			allocationDetails.setFuelName(fuelType);
			allocationDetails.setAllocatedAmount(requestedFuelAmount);
			allocationDetails.setAllocatedStatus("NOT ALLOCATED");
			allocationDetails.setAllocatedMessage(allocationStatusMesssage);
			allocationProducer.sendMessage(allocationDetails);
			saveAllocationDetails(allocationDetails);

			
		}
		return allocationStatusMesssage;
	}

	@PostMapping(path="/create")
	public void saveAllocationDetails(@RequestBody AllocationDetails allocationDetails) {
		// TODO Auto-generated method stub
		allocationDetails = allocationRepository.save(allocationDetails);
		
		
	
	}
}
