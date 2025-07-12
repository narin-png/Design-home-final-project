package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.ListServiceDto;
import az.coders.Design.homes.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/list-service")
public class ListServiceController {
    private final ListService listService;
    @GetMapping
    public ResponseEntity<List<ListServiceDto>> getAllServices() {
        return ResponseEntity.ok(listService.getAllServices());
    }

    // ✅ Get service by ID
    @GetMapping("/{id}")
    public ResponseEntity<ListServiceDto> getServiceById(@PathVariable Integer id) {
        return ResponseEntity.ok(listService.getServiceById(id));
    }

    // ✅ Create new service
    @PostMapping
    public ResponseEntity<ListServiceDto> saveService(@RequestBody ListServiceDto serviceDto) {
        return ResponseEntity.ok(listService.saveService(serviceDto));
    }

    // ✅ Update service
    @PutMapping("/{id}")
    public ResponseEntity<ListServiceDto> updateService(
            @PathVariable Integer id,
            @RequestBody ListServiceDto serviceDto) {
        return ResponseEntity.ok(listService.updateService(id, serviceDto));
    }

    // ✅ Delete service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        listService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
