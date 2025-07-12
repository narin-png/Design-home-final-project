package az.coders.Design.homes.dto.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
    private Integer id;
    private String path;
    private MediaTypeDto mediaTypeDto;
}
