package com.raceco.apii.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "SecurityToken")
public class SecurityToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String tokenType; // e.g., 'RESET_PASSWORD', 'EMAIL_VERIFICATION'

    @Column(nullable = false)
    private Date expirationTime;

    private Boolean isUsed = false;
}