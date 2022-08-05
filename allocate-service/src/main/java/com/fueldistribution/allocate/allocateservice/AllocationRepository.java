package com.fueldistribution.allocate.allocateservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fueldistribution.basedomains.AllocationDetails;
import com.fueldistribution.basedomains.FuelDetails;

public interface AllocationRepository extends JpaRepository<FuelDetails, Integer> {

	AllocationDetails save(AllocationDetails allocationDetails);


}
