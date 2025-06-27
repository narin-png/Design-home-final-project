package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.consultation.ConsultationTopicDto;
import az.coders.Design.homes.entity.ConsultationTopic;

import java.util.List;

public interface ConsultationTopicService {
    List<ConsultationTopicDto> getAllTopics();
    ConsultationTopicDto save(ConsultationTopicDto topic); // Optional if adding new topics
    ConsultationTopic getById(Integer id);
}
