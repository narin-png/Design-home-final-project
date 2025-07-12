package az.coders.Design.homes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "list_services")
@AllArgsConstructor
@NoArgsConstructor
public class ListServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;  //name of blog
    @Column(length = 500)
    private String shortDescription;
    @Lob
    private String content;

    @OneToOne
    private Media media;
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<ListProject> projects;

}
