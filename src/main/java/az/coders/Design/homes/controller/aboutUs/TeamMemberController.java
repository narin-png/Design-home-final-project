package az.coders.Design.homes.controller.aboutUs;

import az.coders.Design.homes.dto.aboutUs.TeamMemberDto;
import az.coders.Design.homes.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team-member")
public class TeamMemberController {
    private final TeamMemberService teamMemberService;
    @GetMapping
    public ResponseEntity<List<TeamMemberDto>> getAllTeamMembers() {
        return ResponseEntity.ok(teamMemberService.getAllTeamMembers());
    }

    // 🔹 Get a specific team member by ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberDto> getTeamMemberById(@PathVariable Integer id) {
        return ResponseEntity.ok(teamMemberService.getTeamMemberById(id));
    }

    // 🔹 Create new team member (Hire)
    @PostMapping
    public ResponseEntity<TeamMemberDto> createTeamMember(@RequestBody TeamMemberDto teamMemberDto) {
        return ResponseEntity.ok(teamMemberService.createTeamMember(teamMemberDto));
    }

    // 🔹 Update team member (Change info)
    @PutMapping("/{id}")
    public ResponseEntity<TeamMemberDto> updateTeamMember(@PathVariable Integer id,
                                                          @RequestBody TeamMemberDto teamMemberDto) {
        return ResponseEntity.ok(teamMemberService.updateTeamMember(id, teamMemberDto));
    }

    // 🔹 Delete team member (Fire)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamMember(@PathVariable Integer id) {
        teamMemberService.deleteTeamMember(id);
        return ResponseEntity.noContent().build();
    }
}
