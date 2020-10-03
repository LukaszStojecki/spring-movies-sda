package com.sda.movies.controller;


import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovieController {


    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    public void createAndAddNewMovie(@RequestBody Movie movie){
        movieRepository.addMovie(movie);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id ) throws Exception {
        return movieRepository.getMovie(id);

    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    @PutMapping("/movies/{id}")
    public void updateMovie(@PathVariable("id") Integer id, @RequestParam(value = "title") String title ) throws Exception {
        movieRepository.getMovie(id).setTitle(title);
    }


}
