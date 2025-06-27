package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.footer.ContactInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactInfoService {
    List<ContactInfoDto> getContactInfo();
    ContactInfoDto saveContactInfo(ContactInfoDto contactInfoDto);
    void deleteContactInfo(Integer id);
}
