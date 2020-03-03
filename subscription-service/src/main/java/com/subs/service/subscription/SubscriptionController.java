package com.subs.service.subscription;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.subs.service.dtos.SubscriptionDto;

public interface SubscriptionController {

	public List<Subscription> getAllSubscriptions();
	
	public ResponseEntity<Subscription> createSubscription(Subscription subscription);
}
