package com.fueldistribution.dispatch.dispatchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fueldistribution.basedomains.DispatchSceduledDetails;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@RestController
@RequestMapping(path="/dispatch")
public class DispatchController {
	
	@Autowired
	private DispatchProducer dispatchProducer;
	
	@Autowired
	DispatchRepository dispatchRepository;
	
	public DispatchController()
	{}  
	
	public DispatchController(DispatchProducer dispatchProducer,DispatchRepository dispatchRepository ) {
		this.dispatchProducer = dispatchProducer;
		this.dispatchRepository  = dispatchRepository;
	}
			

public void dispatchOrder(String refNo, String status, int vehicleNo) {
		//check allocated details
		//check vehcle details
		//schedule dispatch
		//save to db
		//send to kafka
		OrderDispatchDetails dispachDetails = new  OrderDispatchDetails();
		dispachDetails.setRefrenceNo(refNo);
		dispachDetails.setVehicleNo(678516);
		dispachDetails.setStatus("DISPATCH COMPLETED");
		dispatchRepository.save(dispachDetails);
		dispatchProducer.sendMessage(dispachDetails);
	}




}
