package com.raceco.apii.Service;

import com.raceco.apii.Entity.Report;
import com.raceco.apii.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getReportsByTrack(Long trackId) {
        return reportRepository.findByTrackTrackId(trackId);
    }

    @Override
    public List<Report> getReportsByUser(Long userId) {
        return reportRepository.findByUserUserId(userId);
    }

    @Override
    public List<Report> getUnresolvedReports() {
        return reportRepository.findByIsResolvedFalse();
    }

    @Override
    public void resolveReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(()->new RuntimeException("Report not found with ID: "+reportId));
        report.setResolved(true);
        reportRepository.save(report);

    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.deleteById(reportId);
    }
}
