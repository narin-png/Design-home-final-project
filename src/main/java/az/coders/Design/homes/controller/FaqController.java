package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.FaqDto;
import az.coders.Design.homes.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {
    private final FaqService faqService;
    @GetMapping
    public ResponseEntity<List<FaqDto>> getAllFaqs() {
        List<FaqDto> faqs = faqService.getAllFaqs();
        return ResponseEntity.ok(faqs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaqDto> getFaqById(@PathVariable Integer id) {
        FaqDto faqDto = faqService.getFaqById(id);
        return ResponseEntity.ok(faqDto);
    }

    @PostMapping
    public ResponseEntity<FaqDto> createFaq(@RequestBody FaqDto faqDto) {
        FaqDto createdFaq = faqService.saveFaq(faqDto);
        return new ResponseEntity<>(createdFaq, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaqDto> updateFaq(@PathVariable Integer id, @RequestBody FaqDto faqDto) {
        FaqDto updatedFaq = faqService.updateFaq(id, faqDto);
        return ResponseEntity.ok(updatedFaq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaq(@PathVariable Integer id) {
        faqService.deleteFaq(id);
        return ResponseEntity.noContent().build();
    }
}
