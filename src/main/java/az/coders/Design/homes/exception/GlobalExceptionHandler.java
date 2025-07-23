package az.coders.Design.homes.exception;

import az.coders.Design.homes.models.ErrorMessageResponse;
import az.coders.Design.homes.service.ErrorMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorMessageService errorMessageService;
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handlerNotFoundException(NotFoundException ex) {
        return ResponseEntity.ok(errorMessageService.getErrorMessageByCode(ex.getErrorCode()));
    }
}
