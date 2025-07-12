package az.coders.Design.homes.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCareerDto {
    private Integer id;
    private String positionName;
    private String location;
    private String jobType;       // Fulltime, Freelance, etc.
    private String workMode;      // Remote, On-site
    private String experience;    // 5+ Years, 3+ Years, etc.
    private String salary;
    private Date deadline;

    private String responsibilities;

    private String requirements;
}
