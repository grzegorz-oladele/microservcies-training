package pl.grzegorz.proxy.reports;

interface ReportRequestService {

    ReportDetailsOutputDto getReport(int pageNumber);
}