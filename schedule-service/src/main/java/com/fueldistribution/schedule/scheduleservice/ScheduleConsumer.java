package com.fueldistribution.schedule.scheduleservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.AllocationDetails;
import com.fueldistribution.basedomains.DispatchSceduledDetails;


@Service
public class ScheduleConsumer {
	
	

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleConsumer.class);
	
	@Autowired
	 private ScheduleController scheduleController;

	@KafkaListener(
			topics= "allocation-topic",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(AllocationDetails allocationDetails) {
		
		
		LOGGER.info(String.format("Scheduled details received in dispatch service => %s", allocationDetails.toString()));
		
		String refNo= allocationDetails.getRefNo();
		int allocatedAmount = allocationDetails.getAllocatedAmount();
		String allocate = "ALLOCATED";
		
		if(allocationDetails.getAllocatedStatus().equals(allocate)) {	
			scheduleController.scheduleDispatch(refNo,allocatedAmount);
}else {
	LOGGER.info(String.format("Scheduled can not be processed: ", refNo));

	}
	}

}
