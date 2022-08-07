package com.fueldistribution.dispatch.dispatchservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.fueldistribution.basedomains.DispatchSceduledDetails;
import com.fueldistribution.basedomains.OrderDispatchDetails;

@Service
public class DispatchProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchProducer.class);
	private NewTopic topic;
	
	private KafkaTemplate<String, DispatchSceduledDetails> kafkaTemplate;
	
	

	public DispatchProducer(NewTopic topic, KafkaTemplate<String, DispatchSceduledDetails> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(OrderDispatchDetails details) {
		LOGGER.info(String.format(" dispatch details: ", details.toString()));
		
		Message<OrderDispatchDetails> message = MessageBuilder
				.withPayload(details)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message);
	}
	
	
}
