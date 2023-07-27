package com.fiona.gatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = "com.fiona.gatewayService") // Change this to the correct package name of your application.
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	KeyResolver userKeyResolver(){
		return exchange -> Mono.just("1");
	}

}
