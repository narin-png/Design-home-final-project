package az.coders.Design.homes.dto.footer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeInfoDto {
    private Integer id;
    private String addressLine1;  // e.g. "4517 Washington Ave."
    private String city;          // e.g. "Manchester"
    private String state;         // e.g. "Kentucky"
    private String zipCode;
}
