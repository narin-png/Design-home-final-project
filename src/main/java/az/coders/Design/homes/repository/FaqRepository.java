package az.coders.Design.homes.repository;

import az.coders.Design.homes.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
}
