package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.FaqDto;
import az.coders.Design.homes.entity.Faq;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.exception.NotFoundException;
import az.coders.Design.homes.repository.FaqRepository;
import az.coders.Design.homes.service.FaqService;
import jakarta.persistence.SequenceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {
    private final FaqRepository faqRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<FaqDto> getAllFaqs() {
        return enhancedObjectMapper.convertList(faqRepository.findAll(), FaqDto.class);
    }

    @Override
    public FaqDto getFaqById(Integer id) {
        Faq faq = faqRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
        return enhancedObjectMapper.convertValue(faq, FaqDto.class);
    }

    @Override
    public FaqDto saveFaq(FaqDto faqDto) {
        Faq faq = enhancedObjectMapper.convertValue(faqDto, Faq.class);
        return enhancedObjectMapper.convertValue(faqRepository.save(faq), FaqDto.class);
    }

    @Override
    public FaqDto updateFaq(Integer id, FaqDto faqDto) {
        Faq existing = faqRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
        existing.setQuestions(faqDto.getQuestions());
        existing.setAnswers(faqDto.getAnswers());

        return enhancedObjectMapper.convertValue(faqRepository.save(existing), FaqDto.class);
    }

    @Override
    public void deleteFaq(Integer id) {
        if (!faqRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.NOT_FOUND);
        }
        faqRepository.deleteById(id);
    }
}
