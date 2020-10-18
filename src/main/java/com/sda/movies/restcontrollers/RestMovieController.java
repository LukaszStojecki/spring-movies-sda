package com.sda.movies.restcontrollers;

import com.sda.movies.model.Movie;
import com.sda.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class RestMovieController {

    private final MovieService movieService;

    @Autowired
    public RestMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findMovies(){
        return movieService.findMovies();
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
       return movieService.saveMovie(movie);
    }

}
