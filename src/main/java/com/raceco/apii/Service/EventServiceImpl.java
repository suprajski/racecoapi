package com.raceco.apii.Service;

import com.raceco.apii.Entity.Event;
import com.raceco.apii.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(()->new RuntimeException("Event not found with ID: "+eventId));
    }

    @Override
    public List<Event> getEventsByTrack(Long trackId) {
        return eventRepository.findByTrackTrackId(trackId);
    }

    @Override
    public List<Event> getEventsByBranch(Long branchId) {return  eventRepository.findByTrackBranchBranchId(branchId);}

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
