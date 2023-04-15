package pl.grzegorz.proxy.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.proxy.tools.PageValidator;

@Service
public class ReportService implements ReportRequestService{

    private final String url;
    private final RestTemplate restTemplate;
    private final PageValidator pageValidator;

    ReportService(@Value("${rest-template.report.host}") String host,
                  RestTemplate restTemplate,
                  PageValidator pageValidator) {
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":8200/reports";
        this.pageValidator = pageValidator;
    }


    public void sendReport(ReportDto reportDto) {
        restTemplate.postForObject(url, reportDto, ReportDto.class);
    }

    @Override
    public ReportDetailsOutputDto getReport(int pageNumber) {
        int totalPages = getTotalPages();
        pageValidator.checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(pageNumber,
                totalPages);
        return restTemplate.getForObject(this.url + "?pageNumber=" + pageNumber,
                ReportDetailsOutputDto.class);
    }

    private Integer getTotalPages() {
        return restTemplate.getForObject(url + "/total-pages", Integer.class);
    }
}