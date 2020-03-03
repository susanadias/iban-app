package com.subs.service.subscription;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
    private SubscriptionRepository subscriptionRepository;

	public List<Subscription> getAllSubscriptions() {
	 return this.subscriptionRepository.findAll();
	}

	@Override
	@Transactional
	public Subscription createNewSubscription(Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

	

}
