package pl.grzegorz.reportservice.reports.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportDetailsOutputDto {

    private ReportInfo info;
    private List<ReportOutputDto> results;
}