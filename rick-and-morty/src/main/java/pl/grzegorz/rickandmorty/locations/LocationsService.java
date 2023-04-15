package pl.grzegorz.rickandmorty.locations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.rickandmorty.tools.PageValidator;

@Service
@RequiredArgsConstructor
class LocationsService {

    private static final String APP_URL = "http://localhost:8000/locations?pageNumber=";
    private static final int NUMBER_OF_PAGES = 7;

    private final LocationsRestTemplateHelper locationsRestTemplateHelper;
    private final PageValidator pageValidator;

    LocationsDto getLocations(int pageNumber) {
        pageValidator.checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(pageNumber,
                NUMBER_OF_PAGES);
        if (pageNumber == 1) {
            LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
            response.getInfo().setNextPage(APP_URL + ++pageNumber);
            response.getInfo().setPreviousPage(null);
            return response;
        }
        if (pageNumber <= 41) {
            LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
            response.getInfo().setNextPage(APP_URL + ++pageNumber);
            response.getInfo().setPreviousPage(APP_URL + (pageNumber - 2));
            return response;
        }
        LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
        response.getInfo().setNextPage(null);
        response.getInfo().setPreviousPage(APP_URL + --pageNumber);
        return response;
    }
}
