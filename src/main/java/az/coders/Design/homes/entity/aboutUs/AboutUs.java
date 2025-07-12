package az.coders.Design.homes.entity.aboutUs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "about_us")
@AllArgsConstructor
@NoArgsConstructor
public class AboutUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int yearsOfExperience;

    private int happyClients;

    private int awardWinningDesigns;


}
