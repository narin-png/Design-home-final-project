package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.footer.LegalLinkDto;
import az.coders.Design.homes.enums.LegalLinkEnum;
import az.coders.Design.homes.repository.footer.LegalLinkRepository;

import java.util.List;

public interface LegalLinkService {
   List<LegalLinkDto> getAllLegalLink();
    LegalLinkDto getLegalLinkByTitle(LegalLinkEnum title);
    LegalLinkDto saveLegalLink(LegalLinkDto legalLinkDto);
    LegalLinkDto updateLegalLink(Integer id,LegalLinkDto legalLinkDto);
}
