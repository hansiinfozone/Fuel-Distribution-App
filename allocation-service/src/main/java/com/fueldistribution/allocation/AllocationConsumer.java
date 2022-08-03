package com.fueldistribution.allocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fueldistribution.basedomains.OrderEvent;


@Service
public class AllocationConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationConsumer.class);
	
	@KafkaListener(
			topics= "${spring.kafka.topic.name}",
			groupId = "${spring.kafka.consumer.group-id}"
			)
	
	public void consume(OrderEvent orderEvent) {
		
		
		LOGGER.info(String.format("Order event received in allocatioon service => %s", orderEvent.toString()));
		
		
		
		//save order event data to databse
	}

	
}
