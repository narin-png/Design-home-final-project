package az.coders.Design.homes.service;

import org.springframework.stereotype.Service;

@Service
public interface SubscriberService {
    void subscribe(String email);
}
