package com.pub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class PubServiceController {

	@Autowired
	PubServiceProxy proxyService;

	@GetMapping("/subscriptions")
	public List<SubscriptionDto> getSubscriptions() {
		return proxyService.getSubscriptions();
	}

}
