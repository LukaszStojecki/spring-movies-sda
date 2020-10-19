package com.sda.movies.service;


import com.sda.movies.model.Ticket;
import com.sda.movies.repo.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static com.sda.movies.repo.ITicketRepository.minimalAgeIsUnder;
import static com.sda.movies.repo.ITicketRepository.priceIsUnder;

@Service
public class TicketService {

    private final ITicketRepository ticketRepository;

    @Autowired
    public TicketService(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket addTicket(Ticket ticket){
        return this.ticketRepository.save(ticket);
    }

    public Page<Ticket> findAllBy(Integer page, Integer limit, Integer age, Integer price) {
        PageRequest pageRequest = PageRequest.of(page, limit);

        Specification<Ticket> specification = Specification.where(null);

        if (age != null) {
            specification = specification.and(minimalAgeIsUnder(age));
        }
        if (price != null) {
            specification = specification.and(priceIsUnder(price));
        }

        return this.ticketRepository.findAll(specification, pageRequest);
    }


}
