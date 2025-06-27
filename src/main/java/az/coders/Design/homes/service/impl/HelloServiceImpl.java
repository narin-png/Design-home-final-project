package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.service.HelloService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloMethodAdmin() {
        return "hello method admin";
    }
}
