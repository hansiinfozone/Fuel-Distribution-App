package com.fueldistribution.schedule.scheduleservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.AllocationDetails;
import com.fueldistribution.basedomains.DispatchSceduledDetails;

@Service
public class DispatchScheduleProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatchScheduleProducer.class);
	private NewTopic topic;
	
	private KafkaTemplate<String, DispatchSceduledDetails> kafkaTemplate;

	public DispatchScheduleProducer(NewTopic topic, KafkaTemplate<String, DispatchSceduledDetails> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(DispatchSceduledDetails details) {
		LOGGER.info(String.format("Schedule dispatch details: ", details.toString()));
		
		Message<DispatchSceduledDetails> message = MessageBuilder
				.withPayload(details)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();
		
		kafkaTemplate.send(message);
	}
	
	
}
