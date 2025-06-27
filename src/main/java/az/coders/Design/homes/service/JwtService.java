package az.coders.Design.homes.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

public interface JwtService {
    Claims parseToken(String token);
    String issueToken(Authentication authentication);
}
