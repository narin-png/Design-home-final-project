package az.coders.Design.homes.dto;

import az.coders.Design.homes.entity.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListServiceDto {
    private Integer id;
    private String title;  //name of blog
    private String shortDescription;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
