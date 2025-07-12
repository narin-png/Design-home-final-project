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
        List<ListProject> projects = listProjectRepository.findAll();

        return projects.stream().map(project -> {
            ListProjectDto dto = enhancedObjectMapper.convertValue(project, ListProjectDto.class);

            if (project.getService() != null) {
                dto.setServiceId(project.getService().getId());
                dto.setServiceTitle(project.getService().getTitle());
            }

            return dto;
        }).toList();
    }

    @Override
    public ListProjectDto getById(Integer id) {
        ListProject project = listProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        ListProjectDto dto = enhancedObjectMapper.convertValue(project, ListProjectDto.class);

        if (project.getService() != null) {
            dto.setServiceId(project.getService().getId());
            dto.setServiceTitle(project.getService().getTitle());
        }

        return dto;
    }

    @Override
    public ListProjectDto save(ListProjectDto dto) {
        ListProject project = enhancedObjectMapper.convertValue(dto, ListProject.class);

        if (dto.getServiceId() != null) {
            ListServiceEntity service = listServiceRepository.findById(dto.getServiceId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            project.setService(service);
        }

        ListProject saved = listProjectRepository.save(project);

        ListProjectDto response = enhancedObjectMapper.convertValue(saved, ListProjectDto.class);
        if (saved.getService() != null) {
            response.setServiceId(saved.getService().getId());
            response.setServiceTitle(saved.getService().getTitle());
        }

        return response;
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

        if (dto.getServiceId() != null) {
            ListServiceEntity service = listServiceRepository.findById(dto.getServiceId())
                    .orElseThrow(() -> new RuntimeException("Service not found"));
            existing.setService(service);
        }

        ListProject updated = listProjectRepository.save(existing);

        ListProjectDto response = enhancedObjectMapper.convertValue(updated, ListProjectDto.class);
        if (updated.getService() != null) {
            response.setServiceId(updated.getService().getId());
            response.setServiceTitle(updated.getService().getTitle());
        }

        return response;
    }

    @Override
    public void delete(Integer id) {
        if (!listProjectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        listProjectRepository.deleteById(id);
    }
}