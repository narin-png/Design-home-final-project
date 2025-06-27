package az.coders.Design.homes.service.impl.consultation;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.consultation.ConsultationDto;
import az.coders.Design.homes.entity.Consultation;
import az.coders.Design.homes.entity.ConsultationTopic;
import az.coders.Design.homes.repository.consultation.ConsultationRepository;
import az.coders.Design.homes.repository.consultation.ConsultationTopicRepository;
import az.coders.Design.homes.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    private final ConsultationTopicRepository consultationTopicRepository;
    @Override
    public List<ConsultationDto> getConsultations() {
        return enhancedObjectMapper.convertList(consultationRepository.findAll(), ConsultationDto.class);
    }

    @Override
    public ConsultationDto submitConsultation(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        consultation.setFullName(consultationDto.getFullName());
        consultation.setEmailAddress(consultationDto.getEmailAddress());
        consultation.setMessages(consultationDto.getMessages());
        consultation.setTopic(consultation.getTopic());

        // bookingTime is auto-set by
        return enhancedObjectMapper.convertValue(consultationRepository.save(consultation),ConsultationDto.class);
    }
}
