package com.fueldistribution.schedule.scheduleservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fueldistribution.basedomains.DispatchSceduledDetails;

public interface ScheduleDispatchRepository extends JpaRepository<DispatchSceduledDetails, Integer> {

}
