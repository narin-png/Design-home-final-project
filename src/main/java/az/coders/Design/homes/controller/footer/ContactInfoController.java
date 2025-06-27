package az.coders.Design.homes.controller.footer;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.footer.ContactInfoDto;
import az.coders.Design.homes.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact-info")
public class ContactInfoController {
    private final ContactInfoService contactInfoService;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @GetMapping
    public ResponseEntity<List<ContactInfoDto>> getContactInfos() {
        return new ResponseEntity<>(contactInfoService.getContactInfo(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ContactInfoDto> createContactInfo(@RequestBody ContactInfoDto contactInfoDto) {
        return new ResponseEntity<>(contactInfoService.saveContactInfo(contactInfoDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContactInfo(@PathVariable Integer id) {
      contactInfoService.deleteContactInfo(id);
        return ResponseEntity.noContent().build();
    }
}
