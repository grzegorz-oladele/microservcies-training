package pl.grzegorz.reportservice.reports;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

import java.util.List;

@Repository
interface ReportRepository extends JpaRepository<ReportEntity, String> {

    List<ReportOutputDto> findAllBy(Pageable pageable);

    ReportOutputDto findAllById(String id);
}
