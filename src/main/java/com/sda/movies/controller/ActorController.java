package com.sda.movies.controller;


import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.repo.IAcotorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActorController {

    private final IAcotorRepository acotorRepository;


    public ActorController(IAcotorRepository acotorRepository) {
        this.acotorRepository = acotorRepository;
    }

    @GetMapping("actor")
    public String getALlActors(Model model ) throws Exception {
        model.addAttribute("actorsVariable",acotorRepository.findAll(PageRequest.of(10,10))
                .getContent());
        return "actors";

    }


}
