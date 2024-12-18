package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Track;
import com.raceco.apii.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @PostMapping
    public ResponseEntity<Track> addTrack(@RequestBody Track track) {
        return ResponseEntity.ok(trackService.addTrack(track));
    }

    @GetMapping("/{trackId}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long trackId) {
        return ResponseEntity.ok(trackService.getTrackById(trackId));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Track>> getTracksByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(trackService.getTracksByCity(cityId));
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<Track>> getTracksByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(trackService.getTracksByBranch(branchId));
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long trackId) {
        trackService.deleteTrack(trackId);
        return ResponseEntity.noContent().build();
    }
}
