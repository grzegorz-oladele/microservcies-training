package pl.grzegorz.rickandmorty.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.rickandmorty.tools.PageValidator;

@Service
@RequiredArgsConstructor
class CharactersService {

    private static final String APP_URL = "http://localhost:8000/characters?pageNumber=";
    private static final int NUMBER_OF_PAGES = 42;

    private final CharactersRestTemplateHelper charactersRestTemplateHelper;
    private final PageValidator pageValidator;

    CharactersDto getResponse(int pageNumber) {
        pageValidator.checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(pageNumber,
                NUMBER_OF_PAGES);
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
}