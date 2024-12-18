package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Event;
import com.raceco.apii.Entity.Track;
import com.raceco.apii.Service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {
    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @Test
    void testAddEvent() {
        Event event = new Event();
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackName("Track1");
        event.setEventId(1L);
        event.setTrack(track);
        event.setStartDate(Date.valueOf(LocalDate.of(2024,12,20)));
        event.setCanUsersRace(true);

        when(eventService.addEvent(any(Event.class))).thenReturn(event);

        ResponseEntity<Event> response = eventController.addEvent(event);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getEventId()).isEqualTo(1L);
        assertThat(response.getBody().getCanUsersRace()).isTrue();
        verify(eventService, times(1)).addEvent(any(Event.class));
    }

    @Test
    void testGetEventById() {
        Event event = new Event();
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackName("Track1");
        event.setEventId(1L);
        event.setTrack(track);
        event.setStartDate(Date.valueOf(LocalDate.of(2024,12,20)));
        event.setCanUsersRace(false);

        when(eventService.getEventById(1L)).thenReturn(event);

        ResponseEntity<Event> response = eventController.getEventById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getEventId()).isEqualTo(1L);
        assertThat(response.getBody().getCanUsersRace()).isFalse();
        verify(eventService, times(1)).getEventById(1L);
    }

    @Test
    void testGetEventsByTrack() {
        Event event1 = new Event();
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackName("Track1");
        event1.setEventId(1L);
        event1.setTrack(track);
        event1.setStartDate(Date.valueOf(LocalDate.of(2024,12,20)));

        Event event2 = new Event();
        Track track2 = new Track();
        track.setTrackId(2L);
        track.setTrackName("Track2");
        event2.setEventId(2L);
        event2.setTrack(track2);
        event2.setStartDate(Date.valueOf(LocalDate.of(2024,12,20)));

        List<Event> events = Arrays.asList(event1, event2);

        when(eventService.getEventsByTrack(100L)).thenReturn(events);

        ResponseEntity<List<Event>> response = eventController.getEventsByTrack(100L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getStartDate()).isEqualTo(Date.valueOf(LocalDate.of(2024,12,20)));
        assertThat(response.getBody().get(1).getStartDate()).isEqualTo(Date.valueOf(LocalDate.of(2024,12,20)));
        verify(eventService, times(1)).getEventsByTrack(100L);
    }

    @Test
    void testDeleteEvent() {
        doNothing().when(eventService).deleteEvent(1L);

        ResponseEntity<Void> response = eventController.deleteEvent(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(eventService, times(1)).deleteEvent(1L);
    }
}
