package com.fueldistribution.order.orderservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fueldistribution.basedomains.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public Optional<Order> fetchOrdertByReferenceNumber(String refNumber) {
		// TODO Auto-generated method stub
		 Optional<Order> order = orderDetailsRepository.findByReferenceNumber(refNumber);
		 if(order.isPresent()) {
			 order.get();
		 }
		 
		 return  order;
	}

	@Override
	public String fetchOrderStatustByReferenceNumber(String referenceNumber) {
		// TODO Auto-generated method stub
		Order order = orderDetailsRepository.findStatusByReferenceNumber(referenceNumber);
		return order.getStatus();
	}

}
