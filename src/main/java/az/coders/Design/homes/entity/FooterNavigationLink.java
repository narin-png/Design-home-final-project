package az.coders.Design.homes.entity;

import az.coders.Design.homes.entity.footer.Footer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "footer_navigation_link")
@AllArgsConstructor
@NoArgsConstructor
public class FooterNavigationLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;  // e.g. "Home", "About", "Services", etc.

    private String url;   // e.g. "/home", "/about", "/services"

    private Integer orderIndex;  // for sorting display order
    @ManyToOne
    @JsonIgnore
    private Footer footer;
}
