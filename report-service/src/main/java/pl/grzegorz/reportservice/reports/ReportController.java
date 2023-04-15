package pl.grzegorz.reportservice.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.reportservice.reports.dto.ReportDetailsOutputDto;
import pl.grzegorz.reportservice.reports.dto.ReportDto;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
class ReportController {

    private final ReportService reportService;

    @GetMapping
    ReportDetailsOutputDto getReports(@RequestParam(name = "pageNumber") int pageNumber) {
        return reportService.getReport(pageNumber);
    }

    @GetMapping("/{id}")
    ReportOutputDto getReportById(@PathVariable String id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    void addReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDto);
    }

    @GetMapping("/total-pages")
    int getTotalPages() {
        return reportService.getTotalPages();
    }
}