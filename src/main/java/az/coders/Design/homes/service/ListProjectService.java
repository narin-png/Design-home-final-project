package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.ListProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListProjectService {
    List<ListProjectDto> getListProjects();
    ListProjectDto getById(Integer id);
    ListProjectDto save(ListProjectDto dto);
    ListProjectDto update(Integer id, ListProjectDto dto);
    void delete(Integer id);
}
