package com.sda.movies.controller;


import com.sda.movies.exception.MovieAlreadyExists;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MovieController {

    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/movies")
    public String createMovie(Movie movie, Model model) throws MovieAlreadyExists {
        Movie movie1 = new Movie();
        movie1.setTitle(movie.getTitle());
        model.addAttribute("movie",movieRepository.addMovie(movie1));
        return "AddedMovie";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable("id") Integer id, Model model ) throws Exception {
        model.addAttribute("movie",movieRepository.getMovie(id));
        return "movie";

    }

    @GetMapping("movies")
    public String  getAllMovies(Model model){
        model.addAttribute("movies",movieRepository.getAllMovies());
        return "movies";
    }

    @PutMapping("/movies/{id}")
    public String updateMovie(@PathVariable("id") Integer id, @RequestParam(value = "title") String title, Model model ) throws Exception {
        model.addAttribute("movie",movieRepository.updateMovie(title,id));
        return "update";
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable("id") Integer id, Model model) throws Exception {
       model.addAttribute("movie",movieRepository.deleteMovie(id));
       return "delete";

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public String movieNotFound() {
        return "404";
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(MovieAlreadyExists.class)
    public String movieExists() {
        return "409";
    }
}
