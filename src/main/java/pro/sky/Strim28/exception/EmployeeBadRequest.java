package pro.sky.Strim28.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeBadRequest  extends RuntimeException{
    public EmployeeBadRequest() {
    }

    public EmployeeBadRequest(String message) {
        super(message);
    }

    public EmployeeBadRequest(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBadRequest(Throwable cause) {
        super(cause);
    }

    public EmployeeBadRequest(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
