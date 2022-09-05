package com.amdocs.assignment.ExServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ExServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExServiceRegistryApplication.class, args);
	}

}
