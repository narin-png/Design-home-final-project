package az.coders.Design.homes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaqDto {
    private Integer id;
    private String questions;
    private String answers;
}
