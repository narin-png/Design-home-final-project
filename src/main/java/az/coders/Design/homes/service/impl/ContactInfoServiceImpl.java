package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.footer.ContactInfoDto;
import az.coders.Design.homes.entity.footer.ContactInfo;
import az.coders.Design.homes.entity.footer.OfficeInfo;
import az.coders.Design.homes.repository.footer.ContactInfoRepository;
import az.coders.Design.homes.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;


    @Override
    public List<ContactInfoDto> getContactInfo() {
        return enhancedObjectMapper.convertList(contactInfoRepository.findAll(), ContactInfoDto.class);
    }

    @Override
    public ContactInfoDto saveContactInfo(ContactInfoDto contactInfoDto) {
        return enhancedObjectMapper.convertValue(contactInfoRepository.save(enhancedObjectMapper.convertValue(contactInfoDto, ContactInfo.class)),ContactInfoDto.class);
    }

    @Override
    public void deleteContactInfo(Integer id) {
        findById(id);
        contactInfoRepository.deleteById(id);
    }
    private ContactInfo findById(Integer id) {
        return contactInfoRepository.findById(id).orElseThrow(()->new RuntimeException("contact info for that id not found"));
    }
}
