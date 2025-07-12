package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.ListServiceDto;
import az.coders.Design.homes.dto.ListServiceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListService {
    List<ListServiceDto> getAllServices();

    ListServiceDto getServiceById(Integer id);

    ListServiceDto saveService(ListServiceDto service);

    ListServiceDto updateService(Integer id, ListServiceDto serviceDto);

    void deleteService(Integer id);

}


