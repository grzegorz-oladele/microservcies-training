package pl.grzegorz.proxy.reports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reports")
@RequiredArgsConstructor
class ReportController {

    private final ReportRequestService reportRequestService;

    @GetMapping
    List<ReportOutputDto> getReports(@RequestParam(name = "pageNumber") int pageNumber) {
        return reportRequestService.getReports(pageNumber);
    }
}
