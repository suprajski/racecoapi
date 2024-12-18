package com.raceco.apii.Service;

import com.raceco.apii.Entity.Report;

import java.util.List;

public interface ReportService {
    Report addReport(Report report);
    List<Report> getReportsByTrack(Long trackId);
    List<Report> getReportsByUser(Long userId);
    List<Report> getUnresolvedReports();
    void resolveReport(Long reportId);
    void deleteReport(Long reportId);
}
