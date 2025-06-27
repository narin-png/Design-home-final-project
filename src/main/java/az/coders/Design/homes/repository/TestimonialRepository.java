package az.coders.Design.homes.repository;

import az.coders.Design.homes.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestimonialRepository extends JpaRepository<Testimonial, Integer> {
    List<Testimonial> getTestimonialByOrderByCreatedAtDesc();
    List<Testimonial> findAllByOrderByRateDesc();
}
