package pl.grzegorz.proxy.rickandmorty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.proxy.reports.ReportDto;
import pl.grzegorz.proxy.reports.ReportService;

import java.time.LocalDateTime;

@Service
class RickAndMortyService {

    private final String host;
    private final String url;
    private final RestTemplate restTemplate;
    private final ReportService reportService;

    RickAndMortyService(@Value("${rest-template.rick-and-morty.host}") String host,
                        RestTemplate restTemplate,
                        ReportService reportService) {
        this.host = host;
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8000";
        this.reportService = reportService;
    }

    @Transactional
    public LocationsDto getAllLocations(int pageNumber) {
        ReportDto reportDto = createReport(pageNumber);
        reportService.sendReport(reportDto);
        return restTemplate.getForObject(url + "/locations?pageNumber=" + pageNumber, LocationsDto.class);
    }

    @Transactional
    public CharactersDto getAllCharacters(int pageNumber) {
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