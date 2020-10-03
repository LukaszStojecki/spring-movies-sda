package com.sda.movies.controller;


import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        movieRepository.addMovieByTitle(movie.getTitle());
    }
}
