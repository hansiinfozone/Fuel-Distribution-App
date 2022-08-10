package com.fueldistribution.order.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fueldistribution.basedomains.AllocationDetails;

@Component
public class OrderConsumerAllocation {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumerAllocation.class);

	@Autowired
	private OrderController orderController;

	public OrderConsumerAllocation() {

	}

	public OrderConsumerAllocation(OrderController orderController) {
		super();
		this.orderController = orderController;
	}

	@KafkaListener(topics = "allocation-topic", groupId = "${spring.kafka.consumer.group-id}")

	public void consume(AllocationDetails[] allocationDetails) {

		LOGGER.info("allocation Details received  in order consumer in order  ");

		for (AllocationDetails allocate : allocationDetails) {
			String refNo = allocate.getRefNo();
			String status = allocate.getAllocatedStatus();
			if (status.equalsIgnoreCase("ALLOCATED")) {
				orderController.updateStatusAllocate(refNo, status);
			}

		}
	}

}
