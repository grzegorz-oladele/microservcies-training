package pl.grzegorz.proxy.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ReportService implements ReportRequestService{

    private final String host;
    private final String url;
    private final RestTemplate restTemplate;

    ReportService(@Value("${rest-template.report.host}") String host, RestTemplate restTemplate) {
        this.host = host;
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8200/reports";
    }


    public void sendReport(ReportDto reportDto) {
        restTemplate.postForObject(url, reportDto, ReportDto.class);
    }

    @Override
    public List<ReportOutputDto> getReports(int pageNumber) {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(url + "?pageNumber=" + pageNumber,
                ReportOutputDto[].class))).toList();
    }
}