package com.sda.movies.restcontrollers;

import com.sda.movies.exception.EntityAlreadyExist;
import com.sda.movies.model.Actor;
import com.sda.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/actors")
public class RestActorControllers {

    private final ActorService actorService;

    @Autowired
    public RestActorControllers(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public Page<Actor> findActors(@RequestParam(required = false, defaultValue = "0") Integer page,
                                  @RequestParam(required = false, defaultValue = "10") Integer limit) {
        return actorService.findActors(page, limit);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

    @PostMapping
    public Actor saveActor(@Valid @RequestBody Actor actor) throws EntityAlreadyExist {
        return actorService.save(actor);
    }

}
