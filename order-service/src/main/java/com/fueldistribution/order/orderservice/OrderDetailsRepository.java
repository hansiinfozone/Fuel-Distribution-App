package com.fueldistribution.order.orderservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailsRepository extends JpaRepository<Order, Integer>{

	Optional<Order> findByReferenceNumber(String refNumber);

	

	
}
