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
			

public void dispatchOrder(String refNo, String status, int vehicleNo) {
//				
		OrderDispatchDetails dispachDetails = new  OrderDispatchDetails();
		dispachDetails.setRefrenceNo(refNo);
		dispachDetails.setVehicleNo(678516);
		dispachDetails.setStatus("COMPLETED");
		dispatchRepository.save(dispachDetails);
		dispatchProducer.sendMessage(dispachDetails);
	}

@PutMapping(path="/update")
public OrderDispatchDetails updateOrder( String referenceNumber)
{
	
	OrderDispatchDetails dispachDetails =new OrderDispatchDetails();
	dispachDetails.setRefrenceNo(referenceNumber);
	dispachDetails.setStatus("COMPLETED");
	dispachDetails = dispatchRepository.save(dispachDetails);
	dispatchProducer.sendMessage(dispachDetails);
	
	return  dispachDetails;

}


private OrderDispatchDetails getOrderDispatchDetailsByRefrenceNo(String referenceNumber) {
	 
	OrderDispatchDetails dispachDetails = dispatchRepository.getOrderDispatchDetailsByRefrenceNo(referenceNumber);
	return dispachDetails;
}


}
