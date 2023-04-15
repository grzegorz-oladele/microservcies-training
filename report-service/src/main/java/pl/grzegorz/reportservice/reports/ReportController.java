package pl.grzegorz.reportservice.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.reportservice.reports.dto.ReportDto;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
class ReportController {

    private final ReportService reportService;

    @GetMapping
    List<ReportOutputDto> getReports(@RequestParam(name = "pageNumber") int pageNumber) {
        return reportService.getReports(pageNumber);
    }

    @GetMapping("/{id}")
    ReportOutputDto getReportById(@PathVariable String id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    void addReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDto);
    }
}