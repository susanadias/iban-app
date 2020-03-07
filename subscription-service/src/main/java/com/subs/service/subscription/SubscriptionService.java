package com.subs.service.subscription;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface SubscriptionService {
	
	List<Subscription> getAllSubscriptions();

	Subscription createNewSubscription(Subscription subscription);
}
