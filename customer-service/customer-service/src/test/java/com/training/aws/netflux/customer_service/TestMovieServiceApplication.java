package com.training.aws.netflux.customer_service;

import org.springframework.boot.SpringApplication;

public class TestMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CustomerServiceApplication::main).
				with(TestContainersConfiguration.class)
				.run(args);
	}

}
