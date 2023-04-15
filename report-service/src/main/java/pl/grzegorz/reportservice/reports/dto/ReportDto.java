package pl.grzegorz.reportservice.reports.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReportDto {

    private String serviceName;
    private LocalDateTime dateOfRequest;
    private int pageOfRequestList;
}
