package az.coders.Design.homes.exception;

import az.coders.Design.homes.enums.ErrorCode;
import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
