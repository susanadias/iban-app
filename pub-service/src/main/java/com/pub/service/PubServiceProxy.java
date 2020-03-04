package com.pub.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@FeignClient(name="subscription-service" )
public interface PubServiceProxy {

	@RequestMapping("api/v1/subscriptions")
	public List<SubscriptionDto> getSubscriptions();
	
	@PostMapping("/employee/find/{id}")
    public SubscriptionDto createNewSubscription(@Valid @RequestBody SubscriptionDto subscription);
}
