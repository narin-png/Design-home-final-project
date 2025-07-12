package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.ListCareerDto;
import az.coders.Design.homes.service.ListCareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/career")
@RequiredArgsConstructor
public class ListCareerController {
    private final ListCareerService listCareerService;
    @GetMapping
    public List<ListCareerDto> getAll() {
        return listCareerService.getAll();
    }

    @GetMapping("/{id}")
    public ListCareerDto getById(@PathVariable Integer id) {
        return listCareerService.getById(id);
    }

    @PostMapping
    public ListCareerDto create(@RequestBody ListCareerDto job) {
        return listCareerService.save(job);
    }

    @PutMapping("/{id}")
    public ListCareerDto update(@PathVariable Integer id, @RequestBody ListCareerDto job) {
        return listCareerService.update(id, job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        listCareerService.delete(id);
    }
}

