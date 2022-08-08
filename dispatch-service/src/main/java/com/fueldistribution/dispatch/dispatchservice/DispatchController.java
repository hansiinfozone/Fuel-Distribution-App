package com.fueldistribution.dispatch.dispatchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fueldistribution.basedomains.DispatchSceduledDetails;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@RestController
@CrossOrigin
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
			
//
//public void dispatchOrder(String refNo, String status, int vehicleNo) {
//		
//		
//		OrderDispatchDetails dispachDetails = new  OrderDispatchDetails();
//		dispachDetails.setRefrenceNo(refNo);
//		dispachDetails.setVehicleNo(678516);
//		dispachDetails.setStatus("DISPATCH COMPLETED");
//		dispatchRepository.save(dispachDetails);
//		dispatchProducer.sendMessage(dispachDetails);
//	}

//@PutMapping(path="/update/{referenceNumber}")
//public ResponseEntity<OrderDispatchDetails> updateOrder(@PathVariable(value = "referenceNumber") String referenceNumber,
//@Validated @RequestBody OrderDispatchDetails dispatch)
//{
//	
//	OrderDispatchDetails dispachDetails = dispatchRepository.getOrderDispatchDetailsByRefrenceNo(referenceNumber);
//	
//	dispachDetails.setStatus("DISPATCH COMPLETED");
//	final OrderDispatchDetails dispachDetail = dispatchRepository.save(dispachDetails);
//	dispatchProducer.sendMessage(dispachDetails);
//	
//	return ResponseEntity.ok(dispachDetail);
//
//}


}
