package az.coders.Design.homes.dto.aboutUs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutUsDto {
    private Integer id;
    private String yearsOfExperience;

    private String happyClients;

    private String awardWinningDesigns;
}
