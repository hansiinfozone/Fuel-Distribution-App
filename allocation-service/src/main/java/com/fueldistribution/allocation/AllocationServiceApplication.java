package com.fueldistribution.allocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.fueldistribution.basedomains")
public class AllocationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllocationServiceApplication.class, args);
	}

}
