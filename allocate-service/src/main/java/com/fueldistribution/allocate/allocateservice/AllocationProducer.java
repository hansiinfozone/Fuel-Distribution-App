package com.fueldistribution.allocate.allocateservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.AllocationDetails;

@Service
public class AllocationProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationProducer.class);
	private NewTopic topic;

	private KafkaTemplate<String, AllocationDetails> kafkaTemplate;

	public AllocationProducer(NewTopic topic, KafkaTemplate<String, AllocationDetails> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(AllocationDetails details) {
		LOGGER.info("Allocation details sending");

		Message<AllocationDetails> message = MessageBuilder.withPayload(details)
				.setHeader(KafkaHeaders.TOPIC, topic.name()).build();

		kafkaTemplate.send(message);
	}

}
