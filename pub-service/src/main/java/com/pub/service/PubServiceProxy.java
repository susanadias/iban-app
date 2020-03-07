package com.pub.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * PubServiceProxy is a proxy to subscription service
 * 
 * 
 */

@FeignClient(name="subscription-service" )
public interface PubServiceProxy {

	@GetMapping("api/v1/subscriptions")
	public List<SubscriptionDto> getSubscriptions();
	
	@PostMapping("api/v1/subscriptions")
    public SubscriptionDto createNewSubscription(@Valid @RequestBody SubscriptionDto subscription);
}
