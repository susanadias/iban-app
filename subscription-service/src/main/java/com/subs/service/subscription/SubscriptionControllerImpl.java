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

import com.subs.service.dtos.SubscriptionDto;


@RestController
@RequestMapping("/api/")
public class SubscriptionControllerImpl implements SubscriptionController{

	@Autowired
	SubscriptionService subcriptionService;
	
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("v1/subscriptions")
	public List<Subscription> getAllSubscriptions() {
		final String ola= new String();
		jmsTemplate.convertAndSend("email", "olasasasaasss");
		return subcriptionService.getAllSubscriptions();
	}

	@PostMapping("v1/subscriptions")
	public ResponseEntity<Subscription> createSubscription(@Valid @RequestBody Subscription subscription) {
		Subscription novo = subcriptionService.createNewSubscription(subscription);
		return new ResponseEntity<Subscription>(novo, HttpStatus.OK);
	}

}
