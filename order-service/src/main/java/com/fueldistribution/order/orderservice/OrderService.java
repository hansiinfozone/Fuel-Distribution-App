package com.fueldistribution.order.orderservice;

import java.util.Optional;

import com.fueldistribution.basedomains.Order;

public interface OrderService {

	Optional<Order> fetchOrdertByReferenceNumber(String refNo);

	String fetchOrderStatustByReferenceNumber(String referenceNumber);

}
