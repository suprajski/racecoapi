package com.raceco.apii.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trackId", nullable = false)
    private Track track;

    @Column(nullable = false)
    private String whatHappened;

    @Column(nullable = false)
    private Date timestamp;

    private Boolean isResolved = false;

    public void setResolved(Boolean resolved) {
        isResolved = resolved;
    }
}