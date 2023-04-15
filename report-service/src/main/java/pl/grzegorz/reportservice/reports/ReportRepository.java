package pl.grzegorz.reportservice.reports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.reportservice.reports.dto.ReportOutputDto;

@Repository
interface ReportRepository extends JpaRepository<ReportEntity, String> {

    Page<ReportOutputDto> findAllBy(Pageable pageable);

    ReportOutputDto findAllById(String id);
}
