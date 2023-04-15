package pl.grzegorz.proxy.rickandmorty.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@RequiredArgsConstructor
class CustomExceptionHandler {

    private final HttpServletRequest request;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleIncorrectPageNumberError(IllegalArgumentException e) {
        return getErrorResponse(e.getMessage(), BAD_REQUEST);
    }

    private ErrorResponse getErrorResponse(String message, HttpStatus status) {
        return ErrorResponse.builder()
                .withMessage(message)
                .withResponseCode(status.value())
                .withTimestamp(LocalDateTime.now().toString())
                .withPath(getCurrentUrlPath())
                .build();
    }

    private String getCurrentUrlPath() {
        return request.getServletPath();
    }
}