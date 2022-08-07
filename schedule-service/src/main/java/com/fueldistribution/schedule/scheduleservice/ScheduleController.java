package com.fueldistribution.schedule.scheduleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fueldistribution.basedomains.DispatchSceduledDetails;

@RestController
@RequestMapping(path="/schedule")
public class ScheduleController {
	
	@Autowired
	private DispatchScheduleProducer dispatchScheduleProducer;
	@Autowired
	ScheduleDispatchRepository scheduleDispatchRepository;
	
	public ScheduleController()
	{}  
	

	
	public ScheduleController(DispatchScheduleProducer dispatchScheduleProducer,
			ScheduleDispatchRepository scheduleDispatchRepository) {
		super();
		this.dispatchScheduleProducer = dispatchScheduleProducer;
		this.scheduleDispatchRepository = scheduleDispatchRepository;
	}

public void scheduleDispatch(String refNo, int allocatedAmount) {
		//check allocated details
		//check vehcle details
		//schedule dispatch
		//save to db
		//send to kafka
		DispatchSceduledDetails dispSceduledDetails = new  DispatchSceduledDetails();
		dispSceduledDetails.setReferenceNo(refNo);
		dispSceduledDetails.setVehicleNo(678516);
		dispSceduledDetails.setDriverName("abh");
		dispSceduledDetails.setStatus("DISPATCH SCHEDULED");
		scheduleDispatchRepository.save(dispSceduledDetails);
		dispatchScheduleProducer.sendMessage(dispSceduledDetails);
	}


public ScheduleController(DispatchScheduleProducer dispatchScheduleProducer) {

	this.dispatchScheduleProducer = dispatchScheduleProducer;
}

}
