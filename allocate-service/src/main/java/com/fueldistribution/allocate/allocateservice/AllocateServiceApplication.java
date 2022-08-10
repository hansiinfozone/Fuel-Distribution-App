package com.fueldistribution.allocate.allocateservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


//main application - AllocationService
@SpringBootApplication
@EntityScan(basePackages = { "com.fueldistribution.basedomains", "com.fueldistribution.order.orderservice" })
public class AllocateServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AllocateServiceApplication.class, args);
	}

}
