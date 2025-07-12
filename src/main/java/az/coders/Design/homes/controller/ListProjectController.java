package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.ListProjectDto;
import az.coders.Design.homes.service.ListProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/list-project")
public class ListProjectController {
    private final ListProjectService listProjectService;
    @GetMapping
    public ResponseEntity<List<ListProjectDto>> getAllProjects() {
        return ResponseEntity.ok(listProjectService.getListProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListProjectDto> getProjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(listProjectService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ListProjectDto> createProject(@RequestBody ListProjectDto dto) {
        return ResponseEntity.ok(listProjectService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListProjectDto> updateProject(@PathVariable Integer id, @RequestBody ListProjectDto dto) {
        return ResponseEntity.ok(listProjectService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        listProjectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
