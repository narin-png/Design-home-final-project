package az.coders.Design.homes.entity;

import az.coders.Design.homes.enums.ErrorCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="error_messages")
public class ErrorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING) // enum sekilinde deyilde string qayitsin deye
    private ErrorCode errorCode;
    private String message;
}
