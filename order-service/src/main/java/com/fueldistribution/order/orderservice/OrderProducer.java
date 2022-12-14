package com.fueldistribution.order.orderservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.fueldistribution.basedomains.Order;

@Service
public class OrderProducer {

	private NewTopic topic;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

	private KafkaTemplate<String, Order> kafkaTemplate;

	public OrderProducer(NewTopic topic, KafkaTemplate<String, Order> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(Order orderevent) {
		LOGGER.info("Order Poducer -- producing the messages");

		Message<Order> message = MessageBuilder.withPayload(orderevent).setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();

		kafkaTemplate.send(message);
	}

//	public void produceOrder(Order order){
//        ObjectMapper mapper = new ObjectMapper();
//        String orderJsonString = null;
//        try {
//            orderJsonString = mapper.writeValueAsString(order);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(
//                String.format("##########\nProduced Order-> %s\n##########", orderJsonString));
//        this.kafkaTemplate.send(AppConstants.ORDER_TOPIC, orderJsonString);
//    }

}
