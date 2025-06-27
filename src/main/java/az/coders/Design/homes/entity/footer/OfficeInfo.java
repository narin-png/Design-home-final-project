package az.coders.Design.homes.entity.footer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="office_infos")
public class OfficeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressLine1;  // e.g. "4517 Washington Ave."
    private String city;          // e.g. "Manchester"
    private String state;         // e.g. "Kentucky"
    private String zipCode;       // e.g. "39495"
}
