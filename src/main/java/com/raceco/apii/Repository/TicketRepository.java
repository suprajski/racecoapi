package com.raceco.apii.Repository;

import com.raceco.apii.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByEventEventId(Long eventId);
    List<Ticket> findByUserUserId(Long userId);
}
