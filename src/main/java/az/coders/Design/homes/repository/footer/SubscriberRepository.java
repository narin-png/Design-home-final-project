package az.coders.Design.homes.repository.footer;

import az.coders.Design.homes.entity.footer.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    Subscriber findByEmail(String email);
}
