package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.TestimonialDto;
import az.coders.Design.homes.dto.footer.LegalLinkDto;
import az.coders.Design.homes.entity.Testimonial;
import az.coders.Design.homes.entity.footer.LegalLink;
import az.coders.Design.homes.repository.TestimonialRepository;
import az.coders.Design.homes.service.TestimonialService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<TestimonialDto> getLatestTestimonials() {
        return enhancedObjectMapper.convertList(testimonialRepository.getTestimonialByOrderByCreatedAtDesc(), TestimonialDto.class);
    }

    @Override
    public List<TestimonialDto> getTopRatedTestimonials() {
        return enhancedObjectMapper.convertList(testimonialRepository.findAllByOrderByRateDesc(),TestimonialDto.class);
    }

    @Override
    public TestimonialDto save(TestimonialDto testimonialDto) {
        return enhancedObjectMapper.convertValue(testimonialRepository.save(enhancedObjectMapper.convertValue(testimonialDto,Testimonial.class)),TestimonialDto.class);
    }

    @Override
    public void delete(Integer id) {
        Testimonial testimonial = testimonialRepository.findById(id).orElseThrow(()->new RuntimeException("doesnt exist"));
        testimonialRepository.delete(testimonial);
    }

    @Override
    public TestimonialDto update(Integer id, TestimonialDto updatedTestimonial) {
        Testimonial existing = testimonialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimonial not found"));
        existing.setName(updatedTestimonial.getName());
        existing.setComment(updatedTestimonial.getComment());
        existing.setRate(updatedTestimonial.getRate());


        return enhancedObjectMapper.convertValue(testimonialRepository.save(existing),TestimonialDto.class);
    }
}
