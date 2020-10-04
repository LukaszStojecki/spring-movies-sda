package com.sda.movies.controller;


import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MovieController {


    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    public String createMovie(Movie movie, Model model) throws MovieAlreadyExist{
            model.addAttribute("added", movieRepository.addMovie(movie));
            return "added";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable("id") Integer id, Model model) throws MovieNotFoundException {
        model.addAttribute("movie", movieRepository.getMovie(id));
        return "movie";

    }

    @GetMapping("/movies")
    public String getAllMovies(Model model){
        model.addAttribute("movies", movieRepository.getAllMovies());
        return "movies";
    }

    @PutMapping("/movies/{id}")
    public String updateMovie(@PathVariable("id") Integer id, @RequestParam(value = "title") String title, Model model) throws MovieNotFoundException {
        model.addAttribute("update", movieRepository.updateMovie(id, title));
        return "update";
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable("id") Integer id, Model model) throws MovieNotFoundException {
        model.addAttribute("delete", movieRepository.deleteMovie(id));
        return "update";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public String movieNotFound(){
        return "404";
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MovieAlreadyExist.class)
    public String movieAlreadyExists(){
        return "409";
    }
}
