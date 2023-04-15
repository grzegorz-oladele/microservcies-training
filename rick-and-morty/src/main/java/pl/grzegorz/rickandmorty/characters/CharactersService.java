package pl.grzegorz.rickandmorty.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CharactersService {

    private static final String APP_URL = "http://localhost:8000/characters?pageNumber=";

    private final CharactersRestTemplateHelper charactersRestTemplateHelper;

    CharactersDto getResponse(int pageNumber) {
        checkPageNumberValueIsLessThanOneAndMoreThanFortyTwoAndThrowExceptionIfIs(pageNumber);
        if (pageNumber == 1) {
            CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
            response.getInfo().setNextPage(APP_URL + ++pageNumber);
            response.getInfo().setPreviousPage(null);
            return response;
        }
        if (pageNumber <= 41) {
            CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
            response.getInfo().setNextPage(APP_URL + ++pageNumber);
            response.getInfo().setPreviousPage(APP_URL + (pageNumber - 2));
            return response;
        }
        CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
        response.getInfo().setNextPage(null);
        response.getInfo().setPreviousPage(APP_URL + --pageNumber);
        return response;
    }

    private void checkPageNumberValueIsLessThanOneAndMoreThanFortyTwoAndThrowExceptionIfIs(int pageNumber) {
        if (pageNumber <= 0 || pageNumber > 42) {
            throw new IllegalArgumentException("Page number isn't correct");
        }
    }
}