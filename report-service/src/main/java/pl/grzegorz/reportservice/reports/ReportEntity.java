package pl.grzegorz.reportservice.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import pl.grzegorz.reportservice.reports.dto.ReportDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(setterPrefix = "with", access = AccessLevel.PRIVATE)
class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String serviceName;
    private LocalDateTime dateOfRequest;
    private int pageOfRequestList;

    static ReportEntity toReportEntity(ReportDto reportDto) {
        return ReportEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withServiceName(reportDto.getServiceName())
                .withDateOfRequest(reportDto.getDateOfRequest())
                .withPageOfRequestList(reportDto.getPageOfRequestList())
                .build();
    }
}
