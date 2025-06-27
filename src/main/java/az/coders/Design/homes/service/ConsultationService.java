package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.consultation.ConsultationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {
    List<ConsultationDto> getConsultations();
    ConsultationDto submitConsultation(ConsultationDto consultationDto);
}
