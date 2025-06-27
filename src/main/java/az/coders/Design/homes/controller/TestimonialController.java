package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.TestimonialDto;
import az.coders.Design.homes.entity.Testimonial;
import az.coders.Design.homes.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testimonial")
public class TestimonialController {
    private final TestimonialService testimonialService;
    @GetMapping("/by time")
    public ResponseEntity<List<TestimonialDto>> getLatest() {
        return ResponseEntity.ok(testimonialService.getLatestTestimonials());
    }
    @GetMapping("/by rate")
    public ResponseEntity<List<TestimonialDto>> getTopRated() {
        return ResponseEntity.ok(testimonialService.getTopRatedTestimonials());
    }
    @PostMapping("/submit")
    public ResponseEntity<TestimonialDto> submitTestimonial(@RequestBody TestimonialDto testimonial) {
        return ResponseEntity.ok(testimonialService.save(testimonial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestimonialDto> updateTestimonial(@PathVariable Integer id,
                                                         @RequestBody TestimonialDto testimonial) {
        return ResponseEntity.ok(testimonialService.update(id, testimonial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Integer id) {
        testimonialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
