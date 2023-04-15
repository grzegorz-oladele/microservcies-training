package pl.grzegorz.rickandmorty.locations;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
class LocationsController {

    private final LocationsService locationsService;

    @GetMapping
    LocationsDto getAllLocations(@RequestParam(name = "pageNumber") int pageNumber) {
        return locationsService.getLocations(pageNumber);
    }
}
