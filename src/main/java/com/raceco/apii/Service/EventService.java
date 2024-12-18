package com.raceco.apii.Service;

import com.raceco.apii.Entity.Event;

import java.util.List;

public interface EventService {
    Event addEvent(Event event);
    Event getEventById(Long eventId);
    List<Event> getEventsByTrack(Long trackId);
    void deleteEvent(Long eventId);
}
