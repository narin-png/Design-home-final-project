package az.coders.Design.homes.controller.footer;

import az.coders.Design.homes.dto.footer.SubscribeRequest;
import az.coders.Design.homes.repository.footer.SubscriberRepository;
import az.coders.Design.homes.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subcriber")
public class SubscriberController {
    private final SubscriberService subscriberService;
    @PostMapping
    public ResponseEntity<String> subscribe(@RequestBody SubscribeRequest request) {
        subscriberService.subscribe(request.getEmail());
        return ResponseEntity.ok("Subscribed successfully.");
    }
}
