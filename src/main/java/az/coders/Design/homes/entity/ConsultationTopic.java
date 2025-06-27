package az.coders.Design.homes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "consultation_topics")
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name; // e.g., "Consultation", "Project Inquiry"
    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
    private List<Consultation> consultations;
}
