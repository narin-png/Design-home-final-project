package az.coders.Design.homes.entity.media;

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
}
