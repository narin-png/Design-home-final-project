package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ListServiceDto;
import az.coders.Design.homes.dto.aboutUs.TeamMemberDto;
import az.coders.Design.homes.entity.ListServiceEntity;
import az.coders.Design.homes.entity.aboutUs.TeamMember;
import az.coders.Design.homes.repository.aboutUs.TeamMemberRepository;
import az.coders.Design.homes.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {
    private final TeamMemberRepository teamMemberRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<TeamMemberDto> getAllTeamMembers() {
        return enhancedObjectMapper.convertList(teamMemberRepository.findAll(), TeamMemberDto.class);
    }

    @Override
    public TeamMemberDto getTeamMemberById(Integer id) {
        return enhancedObjectMapper.convertValue(teamMemberRepository.findById(id).orElseThrow(()->new RuntimeException("team member not found")), TeamMemberDto.class);
    }
    @Override
    public TeamMemberDto createTeamMember(TeamMemberDto teamMemberDto) {
        return enhancedObjectMapper.convertValue(teamMemberRepository.save(enhancedObjectMapper.convertValue(teamMemberDto, TeamMember.class)), TeamMemberDto.class);
    }

    @Override
    public TeamMemberDto updateTeamMember(Integer id, TeamMemberDto teamMemberDto) {
        TeamMember existingTeamMember=teamMemberRepository.findById(id).orElseThrow(()->new RuntimeException("team member not found"));
        existingTeamMember.setFullName(teamMemberDto.getFullName());
        existingTeamMember.setQualification(teamMemberDto.getQualification());
        existingTeamMember.setPosition(teamMemberDto.getPosition());
        existingTeamMember.setLinkedInUrl(teamMemberDto.getLinkedInUrl());
        existingTeamMember.setInstagramUrl(teamMemberDto.getInstagramUrl());
        existingTeamMember.setImage(teamMemberDto.getImage());
        existingTeamMember.setXUrl(teamMemberDto.getXUrl());
        TeamMember updatedTeamMember=teamMemberRepository.save(existingTeamMember);
        return enhancedObjectMapper.convertValue(updatedTeamMember, TeamMemberDto.class);
    }

    @Override
    public void deleteTeamMember(Integer id) {
        if (!teamMemberRepository.existsById(id)) {
            throw new RuntimeException("team member not found ");
        }
        teamMemberRepository.deleteById(id);
    }

}
