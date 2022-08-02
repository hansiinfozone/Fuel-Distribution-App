package com.fueldistribution.order.orderservice;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderProducer {
	

	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	
	public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}



	public void produceOrder(Order order){
        ObjectMapper mapper = new ObjectMapper();
        String orderJsonString = null;
        try {
            orderJsonString = mapper.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(
                String.format("##########\nProduced Order-> %s\n##########", orderJsonString));
        this.kafkaTemplate.send(AppConstants.ORDER_TOPIC, orderJsonString);
    }
	

	
}
