package com.subs.service.subscription;


import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
@Transactional
public interface SubscriptionService {
	
	List<Subscription> getAllSubscriptions();

	Subscription createNewSubscription(Subscription subscription);
}
