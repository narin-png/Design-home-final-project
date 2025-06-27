package az.coders.Design.homes.controller.footer;

import az.coders.Design.homes.dto.footer.OfficeInfoDto;
import az.coders.Design.homes.service.OfficeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/office-info")
public class OfficeInfoContoller {
    private final OfficeInfoService officeInfoService;
    @GetMapping
    public ResponseEntity<List<OfficeInfoDto>> getOfficeInfos() {
        return ResponseEntity.ok(officeInfoService.getOfficeInfos());
    }
    @PostMapping
    public ResponseEntity<OfficeInfoDto> createOfficeInfo(@RequestBody OfficeInfoDto officeInfoDto) {
        return new ResponseEntity<>(officeInfoService.saveOfficeInfo(officeInfoDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOfficeInfo(@PathVariable Integer id) {
        officeInfoService.deleteOfficeInfo(id);
        return ResponseEntity.noContent().build();
    }
}
