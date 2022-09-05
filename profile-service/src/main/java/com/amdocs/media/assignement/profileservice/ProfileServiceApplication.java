package com.amdocs.media.assignement.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.amdocs.media.assignement.profileservice")
@EnableEurekaClient
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
