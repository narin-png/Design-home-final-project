package az.coders.Design.homes.models;

import az.coders.Design.homes.enums.ErrorCode;
import lombok.Data;

@Data
public class ErrorMessageResponse {
    private ErrorCode errorCode;
    private String message;

    public ErrorMessageResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
