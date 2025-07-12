package az.coders.Design.homes.controller.aboutUs;

import az.coders.Design.homes.dto.aboutUs.AboutUsDto;
import az.coders.Design.homes.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/about-us")
public class AboutUsController {
    private final AboutUsService aboutUsService;
    @GetMapping
    public ResponseEntity<List<AboutUsDto>> getAll() {
        return ResponseEntity.ok(aboutUsService.getAboutUs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutUsDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(aboutUsService.getAboutUsById(id));
    }

    @PostMapping
    public ResponseEntity<AboutUsDto> create(@RequestBody AboutUsDto aboutUsDto) {
        return ResponseEntity.ok(aboutUsService.createAboutUs(aboutUsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutUsDto> update(@PathVariable Integer id, @RequestBody AboutUsDto aboutUsDto) {
        return ResponseEntity.ok(aboutUsService.updateAboutUs(id, aboutUsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        aboutUsService.deleteAboutUs(id);
        return ResponseEntity.noContent().build();
    }
}
