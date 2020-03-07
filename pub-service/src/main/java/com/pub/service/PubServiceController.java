package com.pub.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class PubServiceController {

	@Autowired
	PubServiceProxy proxyService;

	@GetMapping("/pub/v1/subscriptions")
	public List<SubscriptionDto> getSubscriptions() {
		return proxyService.getSubscriptions();
	}
	
	@PostMapping("pub/v1/subscriptions")
	public SubscriptionDto createNewSubscription(@Valid @RequestBody SubscriptionDto subscription) {
		return proxyService.createNewSubscription(subscription);
	}

}
