package com.fueldistribution.schedule.scheduleservice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fueldistribution.basedomains.DispatchSceduledDetails;

@RestController
@RequestMapping(path = "/schedule")
public class ScheduleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private DispatchScheduleProducer dispatchScheduleProducer;
	@Autowired
	ScheduleDispatchRepository scheduleDispatchRepository;

	public ScheduleController() {
	}

	public ScheduleController(DispatchScheduleProducer dispatchScheduleProducer,
			ScheduleDispatchRepository scheduleDispatchRepository) {
		super();
		this.dispatchScheduleProducer = dispatchScheduleProducer;
		this.scheduleDispatchRepository = scheduleDispatchRepository;
	}

	public void scheduleDispatch(String refNo, int allocatedAmount) {

		checkVehicleDetails();
		// schedule dispatch

		LOGGER.info("Inside scheduleDispatch method");
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime tomorrow = today.plusDays(1);
		Date date = Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant());

		DispatchSceduledDetails dispSceduledDetails = new DispatchSceduledDetails();
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
