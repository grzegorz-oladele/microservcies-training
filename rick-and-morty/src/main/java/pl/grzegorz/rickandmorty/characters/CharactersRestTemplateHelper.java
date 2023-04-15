package pl.grzegorz.rickandmorty.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
class CharactersRestTemplateHelper {

    private static final String URL = "https://rickandmortyapi.com/api/character?page=";

    private final RestTemplate restTemplate;

    ResponseDto getAllCharacters(int pageNumber) {
        return restTemplate.getForObject(URL + pageNumber, ResponseDto.class);
    }
}