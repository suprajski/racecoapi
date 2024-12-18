package com.raceco.apii.Repository;

import com.raceco.apii.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByTrackTrackId(Long trackId);
    List<Report> findByUserUserId(Long userId);
    List<Report> findByIsResolvedFalse();
}
