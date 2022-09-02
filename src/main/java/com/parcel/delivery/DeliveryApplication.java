package com.parcel.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}

	@PostConstruct
	public void startupApplication() {
		// log startup
		System.out.println("Test ===> Started ");
	}

	@PreDestroy
	public void shutdownApplication() {
		// log shutdown
	}
}
