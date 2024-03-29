package com.study;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerMovieFeignCustomizingApplication {



	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieFeignCustomizingApplication.class, args);
	}

}
