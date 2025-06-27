package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.TestimonialDto;
import az.coders.Design.homes.entity.Testimonial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestimonialService {
    List<TestimonialDto> getLatestTestimonials();
    List<TestimonialDto> getTopRatedTestimonials();
    TestimonialDto save(TestimonialDto testimonialDto);
    void delete(Integer id);
    TestimonialDto update(Integer id, TestimonialDto updatedTestimonial);
}
