package pl.grzegorz.proxy.rickandmorty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.proxy.reports.ReportDto;
import pl.grzegorz.proxy.reports.ReportService;
import pl.grzegorz.proxy.rickandmorty.tools.PageValidator;

import java.time.LocalDateTime;

@Service
class RickAndMortyService {

    private final String host;
    private final String url;
    private final RestTemplate restTemplate;
    private final ReportService reportService;
    private final PageValidator pageValidator;

    RickAndMortyService(@Value("${rest-template.rick-and-morty.host}") String host,
                        RestTemplate restTemplate,
                        ReportService reportService,
                        PageValidator pageValidator) {
        this.host = host;
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8000";
        this.reportService = reportService;
        this.pageValidator = pageValidator;
    }

    public LocationsDto getAllLocations(int pageNumber) {
        pageValidator.checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(pageNumber,
                7);
        ReportDto reportDto = createReport(pageNumber);
        reportService.sendReport(reportDto);
        return restTemplate.getForObject(url + "/locations?pageNumber=" + pageNumber, LocationsDto.class);
    }

    public CharactersDto getAllCharacters(int pageNumber) {
        pageValidator.checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(pageNumber, 42);
        ReportDto reportDto = createReport(pageNumber);
        reportService.sendReport(reportDto);
        return restTemplate.getForObject(url + "/characters?pageNumber=" + pageNumber, CharactersDto.class);
    }

    private ReportDto createReport(int pageNumber) {
        return ReportDto.builder()
                .withServiceName("Rick-and-Morty Service")
                .withDateOfRequest(LocalDateTime.now())
                .withPageOfRequestList(pageNumber)
                .build();
    }
}