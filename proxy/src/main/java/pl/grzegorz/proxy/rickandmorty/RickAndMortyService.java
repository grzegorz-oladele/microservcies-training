package pl.grzegorz.proxy.rickandmorty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class RickAndMortyService {

    private final String host;
    private final String url;
    private final RestTemplate restTemplate;

    RickAndMortyService(@Value("${rest-template.rick-and-morty.host}") String host, RestTemplate restTemplate) {
        this.host = host;
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8000";
    }

    LocationsDto getAllLocations(int pageNumber) {
        return restTemplate.getForObject(url + "/locations?pageNumber=" + pageNumber, LocationsDto.class);
    }

    CharactersDto getAllCharacters(int pageNumber) {
        return restTemplate.getForObject(url + "/characters?pageNumber=" + pageNumber, CharactersDto.class);
    }
}