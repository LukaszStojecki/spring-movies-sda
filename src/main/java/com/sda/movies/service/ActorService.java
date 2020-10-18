package com.sda.movies.service;

import com.sda.movies.model.Actor;
import com.sda.movies.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findActors() {
        return actorRepository.findAll();
    }

    public Page<Actor> findActors(Integer page, Integer limit) {
        return actorRepository.findAll(PageRequest.of(page, limit));
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }


}
