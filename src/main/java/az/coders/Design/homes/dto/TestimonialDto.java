package az.coders.Design.homes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialDto {
    private Integer id;
    private String name;
    private String comment;
    private Integer rate;
    private LocalDateTime createdAt;
}
