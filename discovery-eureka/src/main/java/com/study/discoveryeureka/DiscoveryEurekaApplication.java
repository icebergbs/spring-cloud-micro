package com.study.discoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaServer
@SpringBootApplication
@EnableHystrixDashboard
public class DiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryEurekaApplication.class, args);
	}

}
