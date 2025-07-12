package az.coders.Design.homes.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDTO {
    private Integer id;
    private String token;
    private String userName;
    private boolean valid;
    private Date isssueDate;
    private Date expiresDate;
}
