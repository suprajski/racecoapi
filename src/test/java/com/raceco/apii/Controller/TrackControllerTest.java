package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Track;
import com.raceco.apii.Service.TrackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrackControllerTest {
    @InjectMocks
    private TrackController trackController;

    @Mock
    private TrackService trackService;

    @Test
    void testAddTrack() {
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackName("Sunny Raceway");

        when(trackService.addTrack(any(Track.class))).thenReturn(track);

        ResponseEntity<Track> response = trackController.addTrack(track);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getTrackName()).isEqualTo("Sunny Raceway");
        verify(trackService, times(1)).addTrack(any(Track.class));
    }

    @Test
    void testGetTrackById() {
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackName("Sunny Raceway");

        when(trackService.getTrackById(1L)).thenReturn(track);

        ResponseEntity<Track> response = trackController.getTrackById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getTrackName()).isEqualTo("Sunny Raceway");
        verify(trackService, times(1)).getTrackById(1L);
    }

    @Test
    void testGetTracksByCity() {
        Track track1 = new Track();
        track1.setTrackId(1L);
        track1.setTrackName("Sunny Raceway");

        Track track2 = new Track();
        track2.setTrackId(2L);
        track2.setTrackName("Cloudy Circuit");

        List<Track> tracks = Arrays.asList(track1, track2);

        when(trackService.getTracksByCity(1L)).thenReturn(tracks);

        ResponseEntity<List<Track>> response = trackController.getTracksByCity(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getTrackName()).isEqualTo("Sunny Raceway");
        verify(trackService, times(1)).getTracksByCity(1L);
    }

    @Test
    void testGetTracksByBranch() {
        Track track1 = new Track();
        track1.setTrackId(1L);
        track1.setTrackName("Sunny Raceway");

        Track track2 = new Track();
        track2.setTrackId(2L);
        track2.setTrackName("Cloudy Circuit");

        List<Track> tracks = Arrays.asList(track1, track2);

        when(trackService.getTracksByBranch(1L)).thenReturn(tracks);

        ResponseEntity<List<Track>> response = trackController.getTracksByBranch(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(1).getTrackName()).isEqualTo("Cloudy Circuit");
        verify(trackService, times(1)).getTracksByBranch(1L);
    }

    @Test
    void testDeleteTrack() {
        doNothing().when(trackService).deleteTrack(1L);

        ResponseEntity<Void> response = trackController.deleteTrack(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(trackService, times(1)).deleteTrack(1L);
    }
}
