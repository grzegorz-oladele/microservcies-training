package pl.grzegorz.proxy.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@RequiredArgsConstructor
class CustomExceptionHandler {

    private final HttpServletRequest request;

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse handleIncorrectPageNumberError() {
        return getErrorResponse();
    }

    private ErrorResponse getErrorResponse() {
        return ErrorResponse.builder()
                .withMessage("Invalid page number")
                .withResponseCode(HttpStatus.BAD_REQUEST.value())
                .withTimestamp(LocalDateTime.now().toString())
                .withPath(getCurrentUrlPath())
                .build();
    }

    private String getCurrentUrlPath() {
        return request.getServletPath();
    }
}