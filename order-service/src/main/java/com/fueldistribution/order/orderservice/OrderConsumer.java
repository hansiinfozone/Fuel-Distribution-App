package com.fueldistribution.order.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fueldistribution.basedomains.DispatchSceduledDetails;
import com.fueldistribution.basedomains.OrderDispatchDetails;

public class OrderConsumer {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@Autowired
	private OrderController orderController;

	@KafkaListener(
			topics= "dispatch-topic",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(OrderDispatchDetails dispatchDetails) {
		
		
		LOGGER.info(String.format("Scheduled details received in dispatch service => %s", dispatchDetails.toString()));
		
		String refNo= dispatchDetails.getRefrenceNo();
		String status = dispatchDetails.getStatus();
		
		if(status=="DISPATCH COMPLETED"){
		orderController.updateStatus(refNo,status);
		}
	}
	


}
