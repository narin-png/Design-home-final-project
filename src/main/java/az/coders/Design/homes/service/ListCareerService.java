package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.ListCareerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListCareerService {
    List<ListCareerDto> getAll();
    ListCareerDto getById(Integer id);
    ListCareerDto save(ListCareerDto job);
    ListCareerDto update(Integer id, ListCareerDto updatedJob);
    void delete(Integer id);
}
