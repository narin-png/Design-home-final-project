package az.coders.Design.homes.service.impl.consultation;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.consultation.ConsultationTopicDto;
import az.coders.Design.homes.entity.ConsultationTopic;
import az.coders.Design.homes.repository.consultation.ConsultationTopicRepository;
import az.coders.Design.homes.service.ConsultationTopicService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationTopicServiceimpl implements ConsultationTopicService {
    private final ConsultationTopicRepository consultationTopicRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<ConsultationTopicDto> getAllTopics() {
        return enhancedObjectMapper.convertList(consultationTopicRepository.findAll(), ConsultationTopicDto.class);
    }

    @Override
    public ConsultationTopicDto save(ConsultationTopicDto topic) {
        return enhancedObjectMapper.convertValue(consultationTopicRepository.save(enhancedObjectMapper.convertValue(topic,ConsultationTopic.class)), ConsultationTopicDto.class);

    }

    @Override
    public ConsultationTopic getById(Integer id) {
        return consultationTopicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found"));
    }
}
