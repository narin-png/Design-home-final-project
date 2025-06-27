package az.coders.Design.homes.dto.footer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfoDto {
    private Integer id;
    private String email;         // contact@formora.com
    private String phone;
}
