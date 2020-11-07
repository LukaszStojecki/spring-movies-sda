package com.sda.movies.service;

import com.sda.movies.model.Ticket;
import com.sda.movies.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.sda.movies.repo.TicketRepository.isAboveMinimalAge;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Page<Ticket> findAllBy(Integer page, Integer limit, Integer age) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        if (age != null) {
            return ticketRepository.findAll(isAboveMinimalAge(age), pageRequest);
        }
        return ticketRepository.findAll(pageRequest);
    }

}
