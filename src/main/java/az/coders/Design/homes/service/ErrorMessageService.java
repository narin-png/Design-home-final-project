package az.coders.Design.homes.service;


import az.coders.Design.homes.dto.ErrorMessageDto;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.models.ErrorMessageResponse;

import java.util.List;

public interface ErrorMessageService {
    ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode);
    List<ErrorMessageDto> getErrorMessages();
    ErrorMessageDto getErrorMessageById(Integer id);
    ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto);
    void deleteErrorMessage(Integer id);
    ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto);
}
