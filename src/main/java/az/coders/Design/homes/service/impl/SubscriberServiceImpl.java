package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.entity.footer.Subscriber;
import az.coders.Design.homes.repository.footer.SubscriberRepository;
import az.coders.Design.homes.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {
    private final SubscriberRepository subscriberRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public void subscribe(String email) {
        Optional<Subscriber> optional = Optional.ofNullable(subscriberRepository.findByEmail(email));
        if (optional.isPresent()) {
            throw new IllegalArgumentException("This email is already subscribed.");
        }
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(email);
        subscriber.setSubscribedAt(LocalDateTime.now());
        subscriberRepository.save(subscriber);


    }
}
