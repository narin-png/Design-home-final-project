package az.coders.Design.homes.entity;

import az.coders.Design.homes.entity.media.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "help_centers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title; // e.g. "Help Center"

    @Lob
    private String content; // the text content of the Help Center page
    @OneToOne
    private Media media;
}

