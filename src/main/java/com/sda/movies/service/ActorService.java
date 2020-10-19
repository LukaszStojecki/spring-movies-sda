package com.sda.movies.service;


import com.sda.movies.exception.EntityExistsException;
import com.sda.movies.model.Actor;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.IAcotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final IAcotorRepository acotorRepository;


    @Autowired
    public ActorService(IAcotorRepository acotorRepository) {
        this.acotorRepository = acotorRepository;
    }

    public Iterable<Actor> findActors() {
        return this.acotorRepository.findAll();
    }
    public Page<Actor> findActors(Integer page, Integer limit) {
        return this.acotorRepository.findAll(PageRequest.of(page,limit));
    }

    public void deleteById(Long id) {
         this.acotorRepository.deleteById(id);
    }

    public Actor addMovie(Actor actor) throws EntityExistsException {
        if (this.acotorRepository.existsByNameAndSurname(actor.getName(),actor.getSurname())){
            throw new EntityExistsException("Actor already exists");
        }
        return this.acotorRepository.save(actor);
    }


}
