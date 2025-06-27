package az.coders.Design.homes.repository.footer;

import az.coders.Design.homes.dto.footer.LegalLinkDto;
import az.coders.Design.homes.entity.footer.LegalLink;
import az.coders.Design.homes.enums.LegalLinkEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalLinkRepository extends JpaRepository<LegalLink, Integer> {
    LegalLink findByTitle(LegalLinkEnum title);
}
