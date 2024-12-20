package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Report;
import com.raceco.apii.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.addReport(report));
    }

    @GetMapping("/track/{trackId}")
    public ResponseEntity<List<Report>> getReportsByTrack(@PathVariable Long trackId) {
        return ResponseEntity.ok(reportService.getReportsByTrack(trackId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Report>> getReportsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reportService.getReportsByUser(userId));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<Report>> getUnresolvedReports() {
        return ResponseEntity.ok(reportService.getUnresolvedReports());
    }

    @PutMapping("/{reportId}/resolve")
    public ResponseEntity<Void> resolveReport(@PathVariable Long reportId) {
        reportService.resolveReport(reportId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long reportId) {
        reportService.deleteReport(reportId);
        return ResponseEntity.noContent().build();
    }
}
