package pl.grzegorz.proxy.rickandmorty.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor(access = PRIVATE)
@Builder(setterPrefix = "with")
class ErrorResponse {

    private String message;
    private String timestamp;
    private int responseCode;
    private String path;
}