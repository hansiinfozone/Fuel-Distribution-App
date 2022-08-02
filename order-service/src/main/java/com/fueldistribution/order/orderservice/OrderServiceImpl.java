package com.fueldistribution.order.orderservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public Optional<Order> fetchOrdertByReferenceNumber(Integer refNumber) {
		// TODO Auto-generated method stub
		 Optional<Order> order = orderDetailsRepository.findById(refNumber);
		 if(order.isPresent()) {
			 order.get();
		 }
		 
		 return  order;
	}

}
