package com.fueldistribution.allocate.allocateservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fueldistribution.basedomains.Order;


@Service
public class AllocationConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationConsumer.class);
	
	@Autowired
	 private AllocationController allocationController;

	@KafkaListener(
			topics= "orders-topic",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(Order orderevent) {
		
		
		LOGGER.info(String.format("Order event received in allocatioon service => %s", orderevent.toString()));
		
		String refNo= orderevent.getReferenceNumber();
	    int requestedAmountofFuel = orderevent.getCapacityInLitres();
	    String fuelType = orderevent.getTypeOfFuel();
	    
	    allocationController.allocateFuel(refNo,fuelType,requestedAmountofFuel);
		
	}

	
}
