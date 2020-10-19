package com.sda.movies.rest;


import com.sda.movies.exception.EntityExistsException;
import com.sda.movies.model.Actor;
import com.sda.movies.model.Movie;
import com.sda.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class RestActorController {


    private final ActorService actorService;


    @Autowired
    public RestActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping()
    public Page<Actor> findActors(
            @RequestParam(required = false,defaultValue = "0") Integer page,
            @RequestParam(required = false,defaultValue = "10") Integer limit)
     {
        return actorService.findActors(page,limit);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteById(id);
    }

    @PostMapping
    public Actor addMovie(@RequestBody @Valid Actor actor) throws EntityExistsException {
        return actorService.addMovie(actor);
    }


}
