package com.fueldistribution.order.orderservice;

import java.util.Optional;

public interface OrderService {

	Optional<Order> fetchOrdertByReferenceNumber(Integer refNumber);

}
