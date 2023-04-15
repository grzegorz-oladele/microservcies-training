package pl.grzegorz.proxy.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportInfo {

    private long count;
    private int pages;
    private String nextPage;
    private String previousPage;
}