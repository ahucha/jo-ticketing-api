package com.example.ticketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketing.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
