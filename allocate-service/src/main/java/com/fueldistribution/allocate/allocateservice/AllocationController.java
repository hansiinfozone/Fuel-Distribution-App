package com.fueldistribution.allocate.allocateservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fueldistribution.basedomains.AllocationDetails;

@RestController
@RequestMapping(path = "/allocation")
public class AllocationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationController.class);

	@Autowired
	private AllocationProducer allocationProducer;
	@Autowired
	private AllocationService allocationService;
	@Autowired
	private AllocationRepository allocationRepository;

	public AllocationController() {
	}

	public AllocationController(AllocationProducer allocationProducer) {
		this.allocationProducer = allocationProducer;

	}

	public AllocationController(AllocationService allocationService, AllocationRepository allocationRepository) {

		this.allocationService = allocationService;
		this.allocationRepository = allocationRepository;
	}

	public String allocateFuel(String refNo, String fuelType, int requestedFuelAmount) {

		LOGGER.info("Inside allocate fuel Service method");

		String allocationStatusMesssage = null;
		boolean isAllocateFuel = allocationService.allocateFuel(fuelType, requestedFuelAmount);
		AllocationDetails allocationDetails = new AllocationDetails();
		allocationDetails.setRefNo(refNo);
		allocationDetails.setFuelName(fuelType);
		allocationDetails.setAllocatedAmount(requestedFuelAmount);

		if (isAllocateFuel == true) {

			allocationStatusMesssage = "Fuel amount successfully allocated";
			allocationDetails.setAllocatedStatus("ALLOCATED");
			allocationDetails.setAllocatedMessage(allocationStatusMesssage);
			allocationProducer.sendMessage(allocationDetails);
			saveAllocationDetails(allocationDetails);

		} else {

			allocationStatusMesssage = "Allocation can not be done";
			allocationDetails.setAllocatedStatus("NOT ALLOCATED");
			allocationDetails.setAllocatedMessage(allocationStatusMesssage);
			allocationProducer.sendMessage(allocationDetails);
			saveAllocationDetails(allocationDetails);

		}
		return allocationStatusMesssage;
	}

	@PostMapping(path = "/create")
	public void saveAllocationDetails(@RequestBody AllocationDetails allocationDetails) {

		LOGGER.info("saving allocation details to repository");

		allocationDetails = allocationRepository.save(allocationDetails);

	}
}
