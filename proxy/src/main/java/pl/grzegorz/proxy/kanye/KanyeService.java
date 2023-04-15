package pl.grzegorz.proxy.kanye;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.proxy.reports.ReportDto;
import pl.grzegorz.proxy.reports.ReportService;

import java.time.LocalDateTime;

@Service
class KanyeService {

    private final String url;
    private final RestTemplate restTemplate;
    private final ReportService reportService;

    KanyeService(@Value("${rest-template.kanye.host}") String host,
                 RestTemplate restTemplate,
                 ReportService reportService) {
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":9000/kanye";
        this.reportService = reportService;
    }

    public String getRandomQuote() {
        ReportDto reportDto = createReport();
        reportService.sendReport(reportDto);
        return restTemplate.getForObject(url, String.class);
    }

    private ReportDto createReport() {
        return ReportDto.builder()
                .withServiceName("Kanye Service")
                .withDateOfRequest(LocalDateTime.now())
                .build();
    }
}