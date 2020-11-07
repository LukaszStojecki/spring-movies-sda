package com.sda.movies.restcontrollers;

import com.sda.movies.model.Director;
import com.sda.movies.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class RestDirectorController {

    private final DirectorService directorService;

    @Autowired
    public RestDirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }


    @GetMapping
    public List<Director> findAllDirectors() {
        return directorService.findDirectors();
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }

    @PostMapping
    public Director addDirector(@RequestBody Director director) {
        return directorService.saveDirector(director);
    }

}
