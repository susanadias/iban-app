package service_start;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class SubscriptionController {

	@Autowired
	SubscriptionService subcriptionService;

	@GetMapping("/subscriptions")
	public List<Subscription> getAllSubscriptions() {
		return subcriptionService.getAllSubscriptions();
	}
	
	/* @PostMapping("/subscriptions")
	    public Subscription createSubscription(@Valid @RequestBody Subscription subs) {
	       // return subcriptionService.createNewSubscription(subs);
	    }*/

}
