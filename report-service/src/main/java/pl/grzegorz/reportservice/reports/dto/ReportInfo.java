package pl.grzegorz.reportservice.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReportInfo {

    private long count;
    private int pages;
    private String nextPage;
    private String previousPage;
}