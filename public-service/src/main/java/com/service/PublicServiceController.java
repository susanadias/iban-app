package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/public/api")
public class PublicServiceController {
	
	 @Autowired
	 RestTemplate restTemplate;
	 

	 @GetMapping("v1/subscriptions")
	 public void getSubscriptions() {
		 
		
		 
	        String response = restTemplate.exchange("http://api/v1/subscriptions",
	                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
	 
	        System.out.println("Response Received as " + response);
		 
	 }
	 
	 
	 @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
