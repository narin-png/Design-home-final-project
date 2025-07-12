package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.aboutUs.TeamMemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamMemberService {
    List<TeamMemberDto> getAllTeamMembers();
    TeamMemberDto getTeamMemberById(Integer id);
    TeamMemberDto createTeamMember(TeamMemberDto teamMemberDto);
    TeamMemberDto updateTeamMember(Integer id,TeamMemberDto teamMemberDto);
    void deleteTeamMember(Integer id);
}
