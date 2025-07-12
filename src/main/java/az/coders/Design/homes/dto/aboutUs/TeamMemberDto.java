package az.coders.Design.homes.dto.aboutUs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberDto {
    private Integer id;
    private String fullName;
    private String position; // e.g., Architect, Interior Designer
    private String qualification; // e.g., Master's in Architecture...
    private String instagramUrl;
    private String linkedInUrl;
    private String xUrl; // for Twitter/X
}
