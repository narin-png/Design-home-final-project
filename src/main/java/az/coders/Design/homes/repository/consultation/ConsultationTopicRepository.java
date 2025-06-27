package az.coders.Design.homes.repository.consultation;

import az.coders.Design.homes.entity.Consultation;
import az.coders.Design.homes.entity.ConsultationTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationTopicRepository extends JpaRepository<ConsultationTopic, Integer> {
}
