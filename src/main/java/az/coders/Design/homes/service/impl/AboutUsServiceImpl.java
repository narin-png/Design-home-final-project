package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.aboutUs.AboutUsDto;
import az.coders.Design.homes.entity.aboutUs.AboutUs;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.exception.NotFoundException;
import az.coders.Design.homes.repository.aboutUs.AboutUsRepository;
import az.coders.Design.homes.service.AboutUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsServiceImpl implements AboutUsService {

    private final AboutUsRepository aboutUsRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;
    @Override
    public List<AboutUsDto> getAboutUs() {
        return enhancedObjectMapper.convertList(aboutUsRepository.findAll(), AboutUsDto.class);
    }

    @Override
    public AboutUsDto getAboutUsById(Integer id) {
        return enhancedObjectMapper.convertValue(aboutUsRepository.findById(id).orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND)), AboutUsDto.class);
    }

    @Override
    public AboutUsDto createAboutUs(AboutUsDto aboutUsDto) {
        return enhancedObjectMapper.convertValue(aboutUsRepository.save(enhancedObjectMapper.convertValue(aboutUsDto, AboutUs.class)), AboutUsDto.class);
    }
    @Override
    public AboutUsDto updateAboutUs(Integer id, AboutUsDto aboutUsDto) {
        AboutUs existingAboutUs=aboutUsRepository.findById(id).orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND));
        existingAboutUs.setHappyClients(aboutUsDto.getHappyClients());
        existingAboutUs.setAwardWinningDesigns(aboutUsDto.getAwardWinningDesigns());
        existingAboutUs.setYearsOfExperience(aboutUsDto.getYearsOfExperience());
        AboutUs updatedAboutUs=aboutUsRepository.save(existingAboutUs);
        return enhancedObjectMapper.convertValue(updatedAboutUs,AboutUsDto.class);

    }

    @Override
    public void deleteAboutUs(Integer id) {
        if (!aboutUsRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.NOT_FOUND);
        }
        aboutUsRepository.deleteById(id);
    }

}
