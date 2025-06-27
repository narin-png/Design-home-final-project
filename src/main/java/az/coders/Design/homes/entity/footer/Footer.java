package az.coders.Design.homes.entity.footer;

import az.coders.Design.homes.entity.FooterNavigationLink;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "footers")
@AllArgsConstructor
@NoArgsConstructor
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "footer",cascade = CascadeType.ALL)
    private List<FooterNavigationLink> links;

    // Office address section
    @OneToOne(cascade = CascadeType.ALL)
    private OfficeInfo officeInfo;

    // Contact info section
    @OneToOne(cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    @OneToMany(mappedBy = "footer",cascade = CascadeType.ALL)
    private List<LegalLink> legalLinks;


    // Subscription section (optional)
    @OneToOne(cascade = CascadeType.ALL)
    private Subscriber subscription;
}
