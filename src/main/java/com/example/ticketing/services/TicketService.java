package com.example.ticketing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ticketing.entities.Ticket;
import com.example.ticketing.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket purchaseTicket(Ticket ticket) {
        if (ticket.getQuantity() <= 0) {
            throw new IllegalArgumentException("La quantité de billets doit être supérieure à zéro.");
        }

        double totalPrice = ticket.getPrice() * ticket.getQuantity();
        if (ticket.getQuantity() >= 5) {
            totalPrice *= 0.9;
        }
        ticket.setPrice(totalPrice);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setEvent(ticketDetails.getEvent());
            ticket.setUser(ticketDetails.getUser());
            ticket.setQuantity(ticketDetails.getQuantity());
            ticket.setPurchaseDate(ticketDetails.getPurchaseDate());
            ticket.setPrice(ticketDetails.getPrice());
            return ticketRepository.save(ticket);
        } else {
            return null;
        }
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
