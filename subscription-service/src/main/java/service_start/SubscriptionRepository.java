package service_start;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> { 

}
