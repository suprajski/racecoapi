package com.raceco.apii.Service;

import com.raceco.apii.Entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket addTicket(Ticket ticket);
    Ticket getTicketById(Long ticketId);
    List<Ticket> getTicketsByEvent(Long eventId);
    List<Ticket> getTicketsByUser(Long userId);
    void deleteTicket(Long ticketId);
}
