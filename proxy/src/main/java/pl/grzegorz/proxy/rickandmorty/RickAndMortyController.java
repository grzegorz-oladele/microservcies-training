package pl.grzegorz.proxy.rickandmorty;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rick-and-morty")
@RequiredArgsConstructor
class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;

    @GetMapping("/locations")
    LocationsDto getAllLocations(@RequestParam(name = "pageNumber") int pageNumber) {
        return rickAndMortyService.getAllLocations(pageNumber);
    }

    @GetMapping("/characters")
    CharactersDto getAllCharacters(@RequestParam(name = "pageNumber") int pageNumber) {
        return rickAndMortyService.getAllCharacters(pageNumber);
    }
}