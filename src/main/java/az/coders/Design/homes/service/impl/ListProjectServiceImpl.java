package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ListProjectDto;
import az.coders.Design.homes.dto.ListServiceDto;
import az.coders.Design.homes.entity.ListProject;
import az.coders.Design.homes.entity.ListServiceEntity;
import az.coders.Design.homes.repository.ListProjectRepository;
import az.coders.Design.homes.repository.ListServiceRepository;
import az.coders.Design.homes.service.ListProjectService;
import az.coders.Design.homes.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProjectServiceImpl implements ListProjectService {
    private final ListProjectRepository listProjectRepository;
    private final ListServiceRepository listServiceRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;

    @Override
    public List<ListProjectDto> getListProjects() {
        return enhancedObjectMapper.convertList(listProjectRepository.findAll(), ListProjectDto.class);
    }

    @Override
    public ListProjectDto getById(Integer id) {
        return enhancedObjectMapper.convertValue(listProjectRepository.findById(id).orElseThrow(()->new RuntimeException("not found")), ListProjectDto.class);
    }

    @Override
    public ListProjectDto save(ListProjectDto dto) {
        ListProject project = enhancedObjectMapper.convertValue(dto, ListProject.class);

        if (dto.getService() != null && dto.getService().getId() != null) {
            ListServiceEntity service = listServiceRepository.findById(dto.getService().getId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            project.setService(service);
        }

        return enhancedObjectMapper.convertValue(listProjectRepository.save(project), ListProjectDto.class);
    }

    @Override
    public ListProjectDto update(Integer id, ListProjectDto dto) {
        ListProject existing = listProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        existing.setProjectName(dto.getProjectName());
        existing.setClient(dto.getClient());
        existing.setType(dto.getType());
        existing.setSize(dto.getSize());
        existing.setBedroom(dto.getBedroom());
        existing.setBathroom(dto.getBathroom());
        existing.setLocation(dto.getLocation());
        existing.setStatus(dto.getStatus());
        existing.setOverview(dto.getOverview());
        existing.setSolution(dto.getSolution());
        existing.setResult(dto.getResult());

        if (dto.getService() != null && dto.getService().getId() != null) {
            ListServiceEntity service = listServiceRepository.findById(dto.getService().getId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            existing.setService(service);
        }

        ListProject updated = listProjectRepository.save(existing);
        return enhancedObjectMapper.convertValue(updated, ListProjectDto.class);
    }

    @Override
    public void delete(Integer id) {
        if (!listProjectRepository.existsById(id)) {
            throw new RuntimeException("Service not found with id: " + id);
        }
        listProjectRepository.deleteById(id);
    }
}
