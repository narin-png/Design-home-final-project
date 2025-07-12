package az.coders.Design.homes.service.impl.footer;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.footer.LegalLinkDto;
import az.coders.Design.homes.entity.footer.LegalLink;
import az.coders.Design.homes.enums.LegalLinkEnum;
import az.coders.Design.homes.repository.footer.LegalLinkRepository;
import az.coders.Design.homes.service.LegalLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LegalLinkServiceImpl implements LegalLinkService {
    private final LegalLinkRepository legalLinkRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<LegalLinkDto> getAllLegalLink() {
        return enhancedObjectMapper.convertList(legalLinkRepository.findAll(),LegalLinkDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public LegalLinkDto getLegalLinkByTitle(LegalLinkEnum title) {
        return enhancedObjectMapper.convertValue(legalLinkRepository.findByTitle(title), LegalLinkDto.class);
    }

    @Override
    public LegalLinkDto saveLegalLink(LegalLinkDto legalLinkDto) {
        return enhancedObjectMapper.convertValue(legalLinkRepository.save(enhancedObjectMapper.convertValue(legalLinkDto, LegalLink.class)), LegalLinkDto.class);
    }

    @Override
    public LegalLinkDto updateLegalLink(Integer id,LegalLinkDto legalLinkDto) {
        LegalLink findLegalLink=legalLinkRepository.findById(id).get();
        LegalLink legalLink=enhancedObjectMapper.convertValue(legalLinkDto, LegalLink.class);
        legalLink.setId(findLegalLink.getId());
        return enhancedObjectMapper.convertValue(legalLinkRepository.save(legalLink),LegalLinkDto.class);
    }
}
