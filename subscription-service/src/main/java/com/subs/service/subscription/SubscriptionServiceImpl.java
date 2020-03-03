package service_start;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
    private SubscriptionRepository subcriptionRepository;

	public List<Subscription> getAllSubscriptions() {
	 return this.subcriptionRepository.findAll();
	}

	@Override
	public Subscription createNewSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

}
