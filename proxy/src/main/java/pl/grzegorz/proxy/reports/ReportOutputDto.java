package pl.grzegorz.proxy.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class ReportOutputDto {

    private String id;
    private String serviceName;
    private LocalDateTime dateOfRequest;
    private int pageOfRequestList;
}