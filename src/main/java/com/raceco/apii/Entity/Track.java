package com.raceco.apii.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;

    @ManyToOne
    @JoinColumn(name = "cityId", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;

    @Column(nullable = false)
    private String trackName;

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Branch getBranch() {
        return branch;
    }

    public City getCity() {
        return city;
    }

    public Long getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }


}