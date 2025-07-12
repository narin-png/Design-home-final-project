package az.coders.Design.homes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "list_careers")
@AllArgsConstructor
@NoArgsConstructor
public class ListCareer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String positionName;
    private String location;
    private String jobType;       // Fulltime, Freelance, etc.
    private String workMode;      // Remote, On-site
    private String experience;    // 5+ Years, 3+ Years, etc.
    private String  salary;

    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Column(columnDefinition = "TEXT")
    private String responsibilities;

    @Column(columnDefinition = "TEXT")
    private String requirements;
}
