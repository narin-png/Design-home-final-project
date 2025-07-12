package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.FaqDto;

import java.util.List;

public interface FaqService {
    List<FaqDto> getAllFaqs();
    FaqDto getFaqById(Integer id);
    FaqDto saveFaq(FaqDto faqDto);
    FaqDto updateFaq(Integer id, FaqDto faqDto);
    void deleteFaq(Integer id);
}
