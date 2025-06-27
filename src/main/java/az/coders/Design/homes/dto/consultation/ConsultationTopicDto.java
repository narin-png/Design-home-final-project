package az.coders.Design.homes.dto.consultation;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationTopicDto {
    private Integer id;
    private String name; // e.g., "Consultation", "Project Inquiry"
}
