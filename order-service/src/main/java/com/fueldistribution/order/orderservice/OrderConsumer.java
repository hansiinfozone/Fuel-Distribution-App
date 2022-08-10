package com.fueldistribution.order.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@Component
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@Autowired
	private OrderController orderController;

	public OrderConsumer() {

	}

	public OrderConsumer(OrderController orderController) {
		super();
		this.orderController = orderController;
	}

	@KafkaListener(topics = "dispatch-topic", groupId = "${spring.kafka.consumer.group-id}")

	public void consume(OrderDispatchDetails[] dispatchDetails) {

		LOGGER.info("dispatch details received  in order consumer in order ");

		for (OrderDispatchDetails dispatch : dispatchDetails) {
			String refNo = dispatch.getRefrenceNo();
			String status = dispatch.getStatus();
			if (status.equalsIgnoreCase("COMPLETED")) {
				orderController.updateStatus(refNo, status);
			}

		}
	}

}
