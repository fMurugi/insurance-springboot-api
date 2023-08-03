package com.fiona.premiumCalculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.fiona"})
public class PremiumCalculationApplication {
	public static void main(String[] args) {
		SpringApplication.run(PremiumCalculationApplication.class, args);
	}

}
