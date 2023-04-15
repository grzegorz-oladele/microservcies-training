package pl.grzegorz.rickandmorty.characters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class CharactersService {

    private static final int NUMBER_OF_PAGES = 42;
    private final CharactersRestTemplateHelper charactersRestTemplateHelper;
    private final String proxyUrl;

    CharactersService(CharactersRestTemplateHelper charactersRestTemplateHelper,
                      @Value("${rest-template.proxy.host}") String proxyHost) {
        this.charactersRestTemplateHelper = charactersRestTemplateHelper;
        this.proxyUrl = "http://" + proxyHost + ":8100/api/rick-and-morty/characters?pageNumber=";
    }

    CharactersDto getCharacters(int pageNumber) {
        if (pageNumber == 1) {
            CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
            response.getInfo().setNextPage(proxyUrl + ++pageNumber);
            response.getInfo().setPreviousPage(null);
            return response;
        }
        if (pageNumber <= NUMBER_OF_PAGES - 1) {
            CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
            response.getInfo().setNextPage(proxyUrl + ++pageNumber);
            response.getInfo().setPreviousPage(proxyUrl + (pageNumber - 2));
            return response;
        }
        CharactersDto response = charactersRestTemplateHelper.getAllCharacters(pageNumber);
        response.getInfo().setNextPage(null);
        response.getInfo().setPreviousPage(proxyUrl + --pageNumber);
        return response;
    }
}