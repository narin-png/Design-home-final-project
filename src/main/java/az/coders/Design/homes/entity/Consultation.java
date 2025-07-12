package az.coders.Design.homes.entity;

import az.coders.Design.homes.entity.media.Media;
import az.coders.Design.homes.enums.ConsultationTopicEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consultations")
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Full Name cannot be empty")
    private String fullName;

    @NotBlank(message = "Email address cannot be empty")
    @Email(message = "Email address must be a valid email format")
    private String emailAddress;

    @NotBlank(message = "Topic cannot be empty")
    private ConsultationTopicEnum topic;

    @Size(max = 500, message = "Messages cannot exceed 500 characters")
    private String messages;

    @Column(nullable = false)
    private LocalDateTime bookingTime; // Timestamp for when the consultation was booked
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Media media;
    @PrePersist
    public void prePersist() {
        this.bookingTime = LocalDateTime.now();
    }
}
