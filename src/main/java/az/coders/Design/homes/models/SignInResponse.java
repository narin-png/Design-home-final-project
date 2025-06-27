package az.coders.Design.homes.models;

import az.coders.Design.homes.dto.RefreshTokenDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResponse {
    private AccessTokenResponse accessToken;
    private RefreshTokenDTO refreshToken;
}
