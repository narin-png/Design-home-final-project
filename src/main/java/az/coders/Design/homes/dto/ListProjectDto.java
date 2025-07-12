package az.coders.Design.homes.dto;

import az.coders.Design.homes.entity.ListServiceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProjectDto {
    private Integer id;
    private String projectName;
    private String client;
    private String type;
    private String size;
    private int bedroom;
    private int bathroom;
    private String location;
    private Integer serviceId;       // Send this from frontend
    private String serviceTitle;     // Set this in response
    private String status;
    private String overview;
    private String solution;
    private String result;
}
