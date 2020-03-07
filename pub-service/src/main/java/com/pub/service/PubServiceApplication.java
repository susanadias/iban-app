package com.pub.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/*
 * PubService is a service that will consume the subscription service in REST API
 * 
 * 
 */

@SpringBootApplication
@EnableFeignClients
public class PubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubServiceApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
