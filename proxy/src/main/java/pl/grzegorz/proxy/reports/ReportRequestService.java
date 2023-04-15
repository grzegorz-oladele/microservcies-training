package pl.grzegorz.proxy.reports;

import java.util.List;

interface ReportRequestService {

    List<ReportOutputDto> getReports(int pageNumber);
}