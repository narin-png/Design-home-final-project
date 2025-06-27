package az.coders.Design.homes.dto.consultation;

import az.coders.Design.homes.enums.ConsultationTopicEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {
    private Integer id;
    private String fullName;
    private String emailAddress;
    private ConsultationTopicEnum topic;
    private String messages;
    private LocalDateTime bookingTime;
}
