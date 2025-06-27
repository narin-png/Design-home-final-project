package az.coders.Design.homes.controller.footer;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.footer.LegalLinkDto;
import az.coders.Design.homes.enums.LegalLinkEnum;
import az.coders.Design.homes.service.LegalLinkService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/legal-link")
public class LegalLinkController {
    private final LegalLinkService legalLinkService;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @GetMapping
    public ResponseEntity<List<LegalLinkDto>> getLegalLinks() {
        return new ResponseEntity<>(legalLinkService.getAllLegalLink(), HttpStatus.OK);
    }
    @GetMapping("/{title}")
    public ResponseEntity<LegalLinkDto> getLegalLink(@PathVariable LegalLinkEnum title) {
        return new ResponseEntity<>(legalLinkService.getLegalLinkByTitle(title),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LegalLinkDto> createLegalLink(@RequestBody LegalLinkDto legalLinkDto) {
        return new ResponseEntity<>(legalLinkService.saveLegalLink(legalLinkDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LegalLinkDto> updateLegalLink(@PathVariable Integer id, @RequestBody LegalLinkDto legalLinkDto) {
        return new ResponseEntity<>(legalLinkService.updateLegalLink(id,legalLinkDto),HttpStatus.OK);
    }
}
