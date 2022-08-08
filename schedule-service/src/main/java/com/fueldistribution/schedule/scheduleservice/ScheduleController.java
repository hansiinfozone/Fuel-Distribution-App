package com.fueldistribution.schedule.scheduleservice;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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
	
		checkVehicleDetails();
		//schedule dispatch
	//date 
		LocalDateTime today = LocalDateTime.now();   
		LocalDateTime tomorrow = today.plusDays(1);
		Date date =Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant()); 
						
		DispatchSceduledDetails dispSceduledDetails = new  DispatchSceduledDetails();
		dispSceduledDetails.setReferenceNo(refNo);
		dispSceduledDetails.setVehicleNo(678516);
		dispSceduledDetails.setDriverName("abh");
		dispSceduledDetails.setStatus("DISPATCH SCHEDULED");
		dispSceduledDetails.setScheduledDate(date);
		scheduleDispatchRepository.save(dispSceduledDetails);
		dispatchScheduleProducer.sendMessage(dispSceduledDetails);
	}


private void checkVehicleDetails() {
	// TODO Auto-generated method stub
	
}



public ScheduleController(DispatchScheduleProducer dispatchScheduleProducer) {

	this.dispatchScheduleProducer = dispatchScheduleProducer;
}

}
