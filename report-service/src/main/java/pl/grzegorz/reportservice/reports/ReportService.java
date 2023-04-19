package pl.grzegorz.reportservice.reports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.grzegorz.reportservice.reports.dto.ReportDetailsOutputDto;
import pl.grzegorz.reportservice.reports.dto.ReportDto;
import pl.grzegorz.reportservice.reports.dto.ReportInfo;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

import java.util.Collections;

@Service
class ReportService {

    private static final int NUMBER_OF_REPORTS_PER_PAGE = 10;
    private final ReportRepository reportRepository;
    private final String proxyUrl;

    ReportService(ReportRepository reportRepository,
                  @Value("${rest-template.proxy.host}") String proxyHost) {
        this.reportRepository = reportRepository;
        this.proxyUrl = "http://" + proxyHost + ":8100/api/reports?pageNumber=";
    }

    int getTotalPages() {
        return reportRepository.findAllBy(PageRequest.of(0, NUMBER_OF_REPORTS_PER_PAGE)).getTotalPages();
    }

    ReportDetailsOutputDto getReport(int pageNumber) {
        Page<ReportOutputDto> reportPage = reportRepository.findAllBy(PageRequest.of(pageNumber - 1,
                NUMBER_OF_REPORTS_PER_PAGE));
        ReportDetailsOutputDto reportDetailsOutputDto = new ReportDetailsOutputDto();
        reportDetailsOutputDto.setResults(reportPage.getContent());
        checkPageNumberIsLessOrEqualZeroOrGreaterThanTotalPagesAndThrowExceptionIfIs(pageNumber);
        setNextPageAndPreviousPage(pageNumber, reportPage, reportDetailsOutputDto);
        return reportDetailsOutputDto;
    }

    private void setNextPageAndPreviousPage(int pageNumber, Page<ReportOutputDto> reportPage,
                                            ReportDetailsOutputDto reportDetailsOutputDto) {
        String nextPage = null;
        String previousPage = null;
        if (pageNumber == 1) {
            nextPage = checkIfPageIsEqualOne(pageNumber, reportPage);
        } else if (pageNumber <= reportPage.getTotalPages() - 1) {
            nextPage = proxyUrl + ++pageNumber;
            previousPage = proxyUrl + (pageNumber - 2);
        } else if (reportPage.getContent().isEmpty()) {
            reportDetailsOutputDto.setResults(Collections.emptyList());
            reportDetailsOutputDto.setInfo(new ReportInfo(0, 0, null, null));
        } else {
            previousPage = proxyUrl + --pageNumber;
        }
        reportDetailsOutputDto.setInfo(new ReportInfo(reportPage.getTotalElements(), reportPage.getTotalPages(),
                nextPage, previousPage));
    }

    private String checkIfPageIsEqualOne(int pageNumber, Page<ReportOutputDto> reportPage) {
        String nextPage;
        if (reportPage.getTotalPages() > 1) {
            nextPage = proxyUrl + ++pageNumber;
            return nextPage;
        } else {
            return null;
        }
    }

    private void checkPageNumberIsLessOrEqualZeroOrGreaterThanTotalPagesAndThrowExceptionIfIs(int pageNumber) {
        if (pageNumber <= -1) {
            throw new IllegalArgumentException("Page number value isn't correct");
        }
    }

    ReportOutputDto getReportById(String id) {
        return reportRepository.findAllById(id);
    }

    void addReport(ReportDto reportDto) {
        ReportEntity reportEntity = ReportEntity.toReportEntity(reportDto);
        reportRepository.save(reportEntity);
    }
}