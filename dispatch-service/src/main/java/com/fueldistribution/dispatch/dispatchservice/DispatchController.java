package com.fueldistribution.dispatch.dispatchservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@RestController
@CrossOrigin
@RequestMapping(path = "/dispatch")
public class DispatchController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchController.class);

	@Autowired
	private DispatchProducer dispatchProducer;

	@Autowired
	DispatchRepository dispatchRepository;

	public DispatchController() {
	}

	public DispatchController(DispatchProducer dispatchProducer, DispatchRepository dispatchRepository) {
		this.dispatchProducer = dispatchProducer;
		this.dispatchRepository = dispatchRepository;
	}

	public void dispatchOrder(String refNo, String status, int vehicleNo) {

		LOGGER.info("Inside dispatch Order method");

		OrderDispatchDetails dispachDetails = new OrderDispatchDetails();
		dispachDetails.setRefrenceNo(refNo);
		dispachDetails.setVehicleNo(678516);
		dispachDetails.setStatus("COMPLETED");
		dispatchRepository.save(dispachDetails);

		LOGGER.info(String.format("Saving to kafka"));
		dispatchProducer.sendMessage(dispachDetails);
	}

	@PutMapping(path = "/update")
	public OrderDispatchDetails updateOrder(String referenceNumber) {
		LOGGER.info("Inside update order");
		OrderDispatchDetails dispachDetails = new OrderDispatchDetails();
		dispachDetails.setRefrenceNo(referenceNumber);
		dispachDetails.setStatus("COMPLETED");
		dispachDetails = dispatchRepository.save(dispachDetails);

		LOGGER.info(String.format("Saving to kafka"));
		dispatchProducer.sendMessage(dispachDetails);

		return dispachDetails;

	}

}
