package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ListBloglDto;
import az.coders.Design.homes.dto.ListServiceDto;
import az.coders.Design.homes.entity.ListServiceEntity;
import az.coders.Design.homes.entity.blog.ListBlog;
import az.coders.Design.homes.repository.ListServiceRepository;
import az.coders.Design.homes.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {
    private final ListServiceRepository listServiceRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;

    @Override
    public List<ListServiceDto> getAllServices() {
        return enhancedObjectMapper.convertList(listServiceRepository.findAll(), ListServiceDto.class);
    }

    @Override
    public ListServiceDto getServiceById(Integer id) {
        return enhancedObjectMapper.convertValue(
                listServiceRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Service not found with id: " + id)),
                ListServiceDto.class
        ); }

    @Override
    public ListServiceDto saveService(ListServiceDto service) {
        return enhancedObjectMapper.convertValue(listServiceRepository.save(enhancedObjectMapper.convertValue(service, ListServiceEntity.class)), ListServiceDto.class);
    }

    @Override
    public ListServiceDto updateService(Integer id, ListServiceDto serviceDto) {
        ListServiceEntity existing = listServiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));

        // Update fields
        existing.setTitle(serviceDto.getTitle());
        existing.setShortDescription(serviceDto.getShortDescription());
        existing.setContent(serviceDto.getContent());

        ListServiceEntity updated = listServiceRepository.save(existing);
        return enhancedObjectMapper.convertValue(updated, ListServiceDto.class);
    }

    @Override
    public void deleteService(Integer id) {
        if (!listServiceRepository.existsById(id)) {
            throw new RuntimeException("Service not found with id: " + id);
        }
        listServiceRepository.deleteById(id);
    }
}
