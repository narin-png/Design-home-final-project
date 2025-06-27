package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.consultation.ConsultationDto;
import az.coders.Design.homes.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultation")
public class ConsultationController {
    private final ConsultationService consultationService;

    @PostMapping
    public ResponseEntity<Void> submit(@RequestBody ConsultationDto consultationDto) {
        consultationService.submitConsultation(consultationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ConsultationDto>> getAllConsultations() {
        return ResponseEntity.ok(consultationService.getConsultations());
    }

}
