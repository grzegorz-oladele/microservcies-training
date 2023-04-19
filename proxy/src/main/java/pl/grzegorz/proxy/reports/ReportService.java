package pl.grzegorz.proxy.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportService implements ReportRequestService{

    private final String url;
    private final RestTemplate restTemplate;

    ReportService(@Value("${rest-template.report.host}") String host,
                  RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8200/reports";
    }


    public void sendReport(ReportDto reportDto) {
        restTemplate.postForObject(url, reportDto, ReportDto.class);
    }

    @Override
    public ReportDetailsOutputDto getReport(int pageNumber) {
        return restTemplate.getForObject(this.url + "?pageNumber=" + pageNumber,
                ReportDetailsOutputDto.class);
    }
}