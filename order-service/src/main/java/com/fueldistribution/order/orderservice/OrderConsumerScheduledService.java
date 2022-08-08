package com.fueldistribution.order.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.AllocationDetails;
import com.fueldistribution.basedomains.DispatchSceduledDetails;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@Component
public class OrderConsumerScheduledService {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumerScheduledService.class);
	
	@Autowired
	private OrderController orderController;
	
	
	public OrderConsumerScheduledService() {
		
	}


	public OrderConsumerScheduledService(OrderController orderController) {
		super();
		this.orderController = orderController;
	}


	@KafkaListener(
			topics= "schedule-topic",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(DispatchSceduledDetails[] dispatchSceduledDetails) {
		
		
		LOGGER.info(String.format("schedule details received in dispatch service "));
		
		for(DispatchSceduledDetails dispatch : dispatchSceduledDetails) {
			String refNo= dispatch.getReferenceNo();
			String status = dispatch.getStatus();
			if(status.equalsIgnoreCase("DISPATCH SCHEDULED")){
				orderController.updateStatusScheduled(refNo,status);
		}

		
		}
	}
	
	


}
