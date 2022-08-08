package com.fueldistribution.order.orderservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fueldistribution.basedomains.Order;


public interface OrderDetailsRepository extends JpaRepository<Order, Integer>{

	Optional<Order> findByReferenceNumber(String refNumber);

	Order findStatusByReferenceNumber(String referenceNumber);

	Order getByReferenceNumber(String refNo);


	

	
}
