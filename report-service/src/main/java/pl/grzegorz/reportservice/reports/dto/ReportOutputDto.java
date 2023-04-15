package pl.grzegorz.reportservice.reports.dto;

import java.time.LocalDateTime;

public interface ReportOutputDto {

    String getId();
    String getServiceName();
    LocalDateTime getDateOfRequest();
    int getPageOfRequestList();
}