package az.coders.Design.homes.dto.aboutUs;

import az.coders.Design.homes.entity.aboutUs.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutUsDto {
    private Integer id;
    private int yearsOfExperience;

    private int happyClients;

    private int awardWinningDesigns;
}
