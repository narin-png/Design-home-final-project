package az.coders.Design.homes.entity.footer;

import az.coders.Design.homes.entity.Media;
import az.coders.Design.homes.enums.LegalLinkEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "legal_links")
@AllArgsConstructor
@NoArgsConstructor
public class LegalLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LegalLinkEnum title;  // "Privacy Policy" or "Terms and Conditions"

    @Lob
    private String content; // the full text of the legal page
    @OneToOne
    private Media media;
    @ManyToOne
    @JsonIgnore
    private Footer footer;

}
