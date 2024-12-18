package com.raceco.apii.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "trackId", nullable = false)
    private Track track;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Boolean canUsersRace = false;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getCanUsersRace() {
        return canUsersRace;
    }

    public void setCanUsersRace(Boolean canUsersRace) {
        this.canUsersRace = canUsersRace;
    }
}