package pl.grzegorz.rickandmorty.locations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class LocationsService {

    private static final int NUMBER_OF_PAGES = 7;
    private final LocationsRestTemplateHelper locationsRestTemplateHelper;
    private final String proxyUrl;

    LocationsService(LocationsRestTemplateHelper locationsRestTemplateHelper,
                     @Value("${rest-template.proxy.host}") String proxyHost) {
        this.locationsRestTemplateHelper = locationsRestTemplateHelper;
        this.proxyUrl = "http://" + proxyHost + ":8100/api/rick-and-morty/locations?pageNumber=";
    }

    LocationsDto getLocations(int pageNumber) {

        if (pageNumber == 1) {
            LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
            response.getInfo().setNextPage(proxyUrl + ++pageNumber);
            response.getInfo().setPreviousPage(null);
            return response;
        }
        if (pageNumber <= NUMBER_OF_PAGES - 1) {
            LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
            response.getInfo().setNextPage(proxyUrl + ++pageNumber);
            response.getInfo().setPreviousPage(proxyUrl + (pageNumber - 2));
            return response;
        }
        LocationsDto response = locationsRestTemplateHelper.getLocations(pageNumber);
        response.getInfo().setNextPage(null);
        response.getInfo().setPreviousPage(proxyUrl + (pageNumber - 1));
        return response;
    }
}