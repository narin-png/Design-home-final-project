package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.aboutUs.AboutUsDto;
import az.coders.Design.homes.entity.aboutUs.AboutUs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AboutUsService {
    List<AboutUsDto> getAboutUs();
    AboutUsDto getAboutUsById(Integer id);
    AboutUsDto createAboutUs(AboutUsDto aboutUsDto);
    AboutUsDto updateAboutUs(Integer id,AboutUsDto aboutUsDto);
    void deleteAboutUs(Integer id);

}
