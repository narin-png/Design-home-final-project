package az.coders.Design.homes.dto;

import az.coders.Design.homes.enums.ErrorCode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class ErrorMessageDto {
    private Integer id;
    @Enumerated(EnumType.STRING) // enum sekilinde deyilde string qayitsin deye
    private ErrorCode errorCode;
}
