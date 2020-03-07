package com.subs.service.subscription;


import java.util.List;

import javax.jms.Destination;
import javax.validation.Valid;

import org.apache.activemq.broker.region.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class SubscriptionControllerImpl implements SubscriptionController{
	
	public static final String JMS_QUEUE_EMAIL="email";

	@Autowired
	SubscriptionService subcriptionService;
	
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("subscriptions")
	public List<Subscription> getAllSubscriptions() {
		return subcriptionService.getAllSubscriptions();
	}

	@PostMapping("subscriptions")
	public ResponseEntity<Subscription> createSubscription(@Valid @RequestBody Subscription subscription) {
		Subscription subscriptionCreated = subcriptionService.createNewSubscription(subscription);
		
		if(subscriptionCreated != null) {
			jmsTemplate.convertAndSend(JMS_QUEUE_EMAIL, subscriptionCreated.getEmailId());
		}
		
		
		return new ResponseEntity<Subscription>(subscriptionCreated, HttpStatus.OK);
	}

}
