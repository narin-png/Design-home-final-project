package az.coders.Design.homes.dto.footer;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalLinkDto {
    private Integer id;
    private String title;  // "Privacy Policy" or "Terms and Conditions"
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content; // the full text of the legal page
}
