package com.study;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerMovieFeignHystrixFallbackStreamApplication {



	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignHystrixFallbackStreamApplication.class, args);
	}

}