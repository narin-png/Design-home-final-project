package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.footer.OfficeInfoDto;

import java.util.List;

public interface OfficeInfoService {
    List<OfficeInfoDto> getOfficeInfos();
    OfficeInfoDto saveOfficeInfo(OfficeInfoDto officeInfoDto);
    void deleteOfficeInfo(Integer id);
}
