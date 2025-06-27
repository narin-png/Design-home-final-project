package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.consultation.ConsultationTopicDto;
import az.coders.Design.homes.entity.ConsultationTopic;
import az.coders.Design.homes.service.ConsultationTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultation-topic")
public class ConsultationTopicController {
    private final ConsultationTopicService service;

    @GetMapping
    public ResponseEntity<List<ConsultationTopicDto>> getAllTopics() {
        return ResponseEntity.ok(service.getAllTopics());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultationTopic> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultationTopicDto> create(@RequestBody ConsultationTopicDto topic) {
        return ResponseEntity.ok(service.save(topic));
    }
}
