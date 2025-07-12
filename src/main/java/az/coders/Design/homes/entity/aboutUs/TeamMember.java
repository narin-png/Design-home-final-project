package az.coders.Design.homes.entity.aboutUs;

import az.coders.Design.homes.entity.media.Media;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "team_members")
@AllArgsConstructor
@NoArgsConstructor
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String position; // e.g., Architect, Interior Designer
    private String qualification; // e.g., Master's in Architecture...
    private String instagramUrl;
    private String linkedInUrl;
    private String xUrl; // for Twitter/X
    @OneToOne
    private Media image;
}
