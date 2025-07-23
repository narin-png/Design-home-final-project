package az.coders.Design.homes.entity.media;

import az.coders.Design.homes.entity.ListProject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "medias")
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String path;
    @Column(nullable = true) // Optional: overlay text may be missing
    private String overlayText;
    @ManyToOne
    private MediaType mediaType;
    @ManyToOne
    @JsonIgnore
    private ListProject listProject;
}
