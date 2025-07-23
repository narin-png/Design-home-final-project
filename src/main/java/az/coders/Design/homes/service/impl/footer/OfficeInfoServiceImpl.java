package az.coders.Design.homes.service.impl.footer;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.footer.OfficeInfoDto;
import az.coders.Design.homes.entity.footer.OfficeInfo;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.exception.NotFoundException;
import az.coders.Design.homes.repository.footer.OfficeInfoRepository;
import az.coders.Design.homes.service.OfficeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeInfoServiceImpl implements OfficeInfoService {
    private final OfficeInfoRepository officeInfoRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;

    @Override
    public List<OfficeInfoDto> getOfficeInfos() {
        return enhancedObjectMapper.convertList(officeInfoRepository.findAll(),OfficeInfoDto.class);
    }

    @Override
    public OfficeInfoDto saveOfficeInfo(OfficeInfoDto officeInfoDto) {
        return enhancedObjectMapper.convertValue(officeInfoRepository.save(enhancedObjectMapper.convertValue(officeInfoDto, OfficeInfo.class)),OfficeInfoDto.class);
    }

    @Override
    public void deleteOfficeInfo(Integer id) {
        findById(id);
        officeInfoRepository.deleteById(id);

    }
    private OfficeInfo findById(Integer id) {
        return officeInfoRepository.findById(id).orElseThrow(()->new NotFoundException(ErrorCode.NOT_FOUND));
    }
}
