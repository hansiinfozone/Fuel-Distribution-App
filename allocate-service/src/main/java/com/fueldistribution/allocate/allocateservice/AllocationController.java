package com.fueldistribution.allocate.allocateservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fueldistribution.basedomains.AllocationDetails;

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
			
			AllocationDetails allocationDetails = new AllocationDetails();
			allocationDetails.setRefNo(refNo);
			allocationDetails.setFuelName(fuelType);
			allocationDetails.setAllocatedAmount(requestedFuelAmount);
			allocationDetails.setAllocatedStatus("ALLOCATED SUCCESSFULLY");
			allocationDetails.setFuelId(100);

			saveAllocationDetails(allocationDetails);


			allocationStatusMesssage = "Fuel amount successfully allocated";

		}
		else {
			allocationStatusMesssage = "Allocation can not be done";
		}
		return allocationStatusMesssage;
	}

	@PostMapping(path="/create")
	public void saveAllocationDetails(@RequestBody AllocationDetails allocationDetails) {
		// TODO Auto-generated method stub
		allocationProducer.sendMessage(allocationDetails);
		allocationDetails = allocationRepository.save(allocationDetails);
		
	
	}
}
