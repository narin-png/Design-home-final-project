package az.coders.Design.homes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBloglDto {
    private Integer id;
    private String title;  //name of blog
    private String content;
    private Date createdAt;
    private Date updatedAt;

}
