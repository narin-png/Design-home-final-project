package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ListBloglDto;
import az.coders.Design.homes.dto.ListCareerDto;
import az.coders.Design.homes.entity.ListCareer;
import az.coders.Design.homes.entity.blog.ListBlog;
import az.coders.Design.homes.repository.ListCareerRepository;
import az.coders.Design.homes.service.ListCareerService;
import lombok.RequiredArgsConstructor;
import org.hibernate.property.access.spi.EnhancedGetterFieldImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCareerServiceImpl implements ListCareerService {
    private final ListCareerRepository listCareerRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;

    @Override
    public List<ListCareerDto> getAll() {
        return enhancedObjectMapper.convertList(listCareerRepository.findAll(), ListCareerDto.class) ;
    }

    @Override
    public ListCareerDto getById(Integer id) {
        return enhancedObjectMapper.convertValue(listCareerRepository.findById(id).orElseThrow(() -> new RuntimeException("career option not found with id: " + id)), ListCareerDto.class) ;
    }

    @Override
    public ListCareerDto save(ListCareerDto job) {
        return enhancedObjectMapper.convertValue(listCareerRepository.save(enhancedObjectMapper.convertValue(job, ListCareer.class)), ListCareerDto.class);
    }

        @Override
    public ListCareerDto update(Integer id, ListCareerDto updatedJob) {
        ListCareer existingCareer=listCareerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("job not found with id: " + id));
        existingCareer.setDeadline(updatedJob.getDeadline());
        existingCareer.setPositionName(updatedJob.getPositionName());
        existingCareer.setResponsibilities(updatedJob.getResponsibilities());
        existingCareer.setRequirements(updatedJob.getRequirements());
        existingCareer.setJobType(updatedJob.getJobType());
        existingCareer.setWorkMode(updatedJob.getWorkMode());
        existingCareer.setSalary(updatedJob.getSalary());
        ListCareer updatedCareer=listCareerRepository.save(existingCareer);
        return enhancedObjectMapper.convertValue(updatedCareer,ListCareerDto.class);
    }

    @Override
    public void delete(Integer id) {
        if (!listCareerRepository.existsById(id)) {
            throw new RuntimeException("job not found with id: " + id);
        }
        listCareerRepository.deleteById(id);

    }
}
