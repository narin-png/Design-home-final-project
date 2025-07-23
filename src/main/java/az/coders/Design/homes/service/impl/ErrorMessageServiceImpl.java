package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ErrorMessageDto;
import az.coders.Design.homes.entity.ErrorMessage;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.exception.NotFoundException;
import az.coders.Design.homes.models.ErrorMessageResponse;
import az.coders.Design.homes.repository.ErrorMessageRepository;
import az.coders.Design.homes.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ErrorMessageServiceImpl implements ErrorMessageService {
    private final ErrorMessageRepository errorMessageRepository;
    private final EnhancedObjectMapper objectMapper;

    @Override
    public ErrorMessageResponse getErrorMessageByCode(ErrorCode errorCode) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(errorCode);
        Optional<ErrorMessage> errorMessage = errorMessageRepository.findByErrorCode(errorCode);
        errorMessage.ifPresent(e -> errorMessageResponse.setMessage(e.getMessage())); // assuming ErrorMessage has `getMessage()`
        return errorMessageResponse;
    }
    @Override
    public List<ErrorMessageDto> getErrorMessages() {
        return objectMapper.convertList(errorMessageRepository.findAll(), ErrorMessageDto.class);
    }

    @Override
    public ErrorMessageDto getErrorMessageById(Integer id) {
        return objectMapper.convertValue(findById(id), ErrorMessageDto.class);
    }

    @Override
        public ErrorMessageDto createErrorMessage(ErrorMessageDto errorMessageDto) {
        //ErrorMessage save = errorMessageRepository.save(mapper.convertValue(errorMessageDto, ErrorMessage.class));
        //save.getTranslations().forEach(translation -> translation.setErrorMessage(save));
        return objectMapper.convertValue(errorMessageRepository.save(objectMapper.convertValue(errorMessageDto, ErrorMessage.class)), ErrorMessageDto.class);
    }

    @Override
    public void deleteErrorMessage(Integer id) {
        findById(id);
        errorMessageRepository.deleteById(id);
    }

    @Override
    public ErrorMessageDto updateErrorMessage(Integer id, ErrorMessageDto errorMessageDto) {
        ErrorMessage findErrorMessage = findById(id);
        ErrorMessage errorMessage = objectMapper.convertValue(errorMessageDto, ErrorMessage.class);
        errorMessage.setId(findErrorMessage.getId());
        return objectMapper.convertValue(errorMessageRepository.save(errorMessage), ErrorMessageDto.class);
    }

    private ErrorMessage findById(Integer id) {
        return errorMessageRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }
}



