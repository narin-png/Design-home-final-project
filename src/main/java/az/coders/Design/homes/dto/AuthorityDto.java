package az.coders.Design.homes.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AuthorityDto implements GrantedAuthority {
    private Integer id;
    private String authority;
}
