package az.coders.Design.homes.repository.consultation;

import az.coders.Design.homes.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
}
