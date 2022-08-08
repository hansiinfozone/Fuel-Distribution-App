package com.fueldistribution.dispatch.dispatchservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fueldistribution.basedomains.DispatchSceduledDetails;


@Service
public class DispatchConsumer {
	
	

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchConsumer.class);
	
	@Autowired
	private DispatchController dispatchController;

	@KafkaListener(
			topics= "schedule-topic",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(DispatchSceduledDetails dispatchDetails) {
		
		
		LOGGER.info(String.format("Scheduled details received in dispatch service => %s", dispatchDetails.toString()));
		
		String refNo= dispatchDetails.getReferenceNo();
		String status = dispatchDetails.getStatus();
		Integer vehicleNo = dispatchDetails.getVehicleNo();
		
		
		//dispatchController.dispatchOrder(refNo,status,vehicleNo);
	}
	}


