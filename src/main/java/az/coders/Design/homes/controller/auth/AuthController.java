package az.coders.Design.homes.controller.auth;

import az.coders.Design.homes.config.JwtFilter;
import az.coders.Design.homes.models.SignInRequest;
import az.coders.Design.homes.models.SignInResponse;
import az.coders.Design.homes.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/sign-in")
    public ResponseEntity< SignInResponse> token(@RequestBody SignInRequest signInRequest){
        SignInResponse signInResponse = authService.signIn(signInRequest);
        authService.signIn( signInRequest );
        HttpHeaders headers = new HttpHeaders();
        authService.setCookies(headers, signInResponse);
        return new ResponseEntity<>(signInResponse,headers, HttpStatus.OK);
    }


    @PostMapping("/sign-out")
    public ResponseEntity<?> signout(@CookieValue(name= JwtFilter.REFRESH_TOKEN) String refreshToken){
        authService.signOut(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        authService.clearCookie(headers);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@CookieValue(name = "refresh-token") String refreshToken) {
        SignInResponse signInResponse = authService.refreshCookie(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        authService.setCookies(headers, signInResponse);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);

    }

}
