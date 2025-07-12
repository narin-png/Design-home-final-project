package az.coders.Design.homes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "list_projects")
@AllArgsConstructor
@NoArgsConstructor
public class ListProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String projectName;
    private String client;
    private String type;
    private String size;
    private int bedroom;
    private int bathroom;
    private String location;
    @ManyToOne // or @OneToOne if each project has exactly one unique service
    @JsonIgnore
    private ListServiceEntity service;
    private String status;

    private String overview;
    private String solution;
    private String result;


}
