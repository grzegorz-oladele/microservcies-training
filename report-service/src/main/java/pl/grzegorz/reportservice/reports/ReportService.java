package pl.grzegorz.reportservice.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.grzegorz.reportservice.reports.dto.ReportDto;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

import java.util.List;

@Service
@RequiredArgsConstructor
class ReportService {

    private static final int NUMBER_OF_REPORTS_PER_PAGE = 10;
    private final ReportRepository reportRepository;

    List<ReportOutputDto> getReports(int pageNumber) {
        return reportRepository.findAllBy(PageRequest.of(pageNumber - 1, NUMBER_OF_REPORTS_PER_PAGE));
    }

    ReportOutputDto getReportById(String id) {
        return reportRepository.findAllById(id);
    }

    void addReport(ReportDto reportDto) {
        ReportEntity reportEntity = ReportEntity.toReportEntity(reportDto);
        reportRepository.save(reportEntity);
    }
}
