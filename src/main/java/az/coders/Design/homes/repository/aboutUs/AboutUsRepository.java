package az.coders.Design.homes.repository.aboutUs;

import az.coders.Design.homes.entity.aboutUs.AboutUs;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutUsRepository extends JpaRepository<AboutUs, Integer> {
}
