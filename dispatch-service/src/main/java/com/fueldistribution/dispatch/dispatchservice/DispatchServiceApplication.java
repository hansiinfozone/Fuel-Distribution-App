package com.fueldistribution.dispatch.dispatchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.fueldistribution.basedomains")
public class DispatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatchServiceApplication.class, args);
	}

}
