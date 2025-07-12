package az.coders.Design.homes.repository.aboutUs;

import az.coders.Design.homes.entity.aboutUs.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
}
