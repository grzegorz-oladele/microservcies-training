package pl.grzegorz.proxy.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
class ReportController {

    private final ReportRequestService reportRequestService;

    @GetMapping
    ReportDetailsOutputDto getReports(@RequestParam(name = "pageNumber") int pageNumber) {
        return reportRequestService.getReport(pageNumber);
    }
}