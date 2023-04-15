package pl.grzegorz.proxy.reports;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(setterPrefix = "with")
public class ReportDto {

    private String serviceName;
    private LocalDateTime dateOfRequest;
    private int pageOfRequestList;
}