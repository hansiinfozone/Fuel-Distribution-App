package com.fueldistributor.kafka.kafkamessaging.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic orderTopicBuilder() {
		return TopicBuilder.name("orderFuel").build();		
	}
}
