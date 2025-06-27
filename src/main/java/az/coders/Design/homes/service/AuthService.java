package az.coders.Design.homes.service;

import az.coders.Design.homes.models.SignInRequest;
import az.coders.Design.homes.models.SignInResponse;
import org.springframework.http.HttpHeaders;

public interface AuthService {
    SignInResponse signIn(SignInRequest signInRequest);

    void setCookies(HttpHeaders headers, SignInResponse signInResponse);

    void clearCookie(HttpHeaders headers);

    void signOut(String refreshToken);



    SignInResponse refreshCookie(String refreshToken);
}
