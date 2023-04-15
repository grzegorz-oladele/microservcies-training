package pl.grzegorz.rickandmorty.locations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
class LocationsRestTemplateHelper {

    private static final String URL = "https://rickandmortyapi.com/api/location?page=";

    private final RestTemplate restTemplate;

    LocationsDto getLocations(int pageNumber) {
        return restTemplate.getForObject(URL + pageNumber, LocationsDto.class);
    }
}
