package com.sda.movies.controller;

import com.sda.movies.repo.ActorRepository;
import com.sda.movies.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/actors")
    public String getAllMovies(Model model){
        model.addAttribute("actors", actorRepository.findAll());
        return "actors";
    }
}
