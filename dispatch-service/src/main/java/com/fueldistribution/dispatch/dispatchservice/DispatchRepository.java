package com.fueldistribution.dispatch.dispatchservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fueldistribution.basedomains.OrderDispatchDetails;

public interface  DispatchRepository extends JpaRepository<OrderDispatchDetails, Integer>{


}
