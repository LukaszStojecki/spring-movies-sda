package com.sda.movies.controller;


import com.sda.movies.exception.EntityExistsException;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MovieController {

    private IMovieRepository movieRepository;

    @Autowired
    public MovieController(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/movies")
    public String createMovie(Movie movie, Model model) throws EntityExistsException {
        Movie movie1 = new Movie();
        movie1.setTitle(movie.getTitle());
        model.addAttribute("movie",movieRepository.save(movie1));
        return "AddedMovie";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable("id") Integer id, Model model ) throws Exception {
        model.addAttribute("movie",movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Not found")));
        return "movie";

    }

    @GetMapping("movies")
    public String  getAllMovies(Model model){
        model.addAttribute("movies",movieRepository.findAll());
        return "movies";
    }
//
//    @PutMapping("/movies/{id}")
//    public String updateMovie(@PathVariable("id") Integer id, @RequestParam(value = "title") String title, Model model ) throws Exception {
//        model.addAttribute("movie",movieRepository.updateMovie(title,id));
//        return "update";
//    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") Integer id) throws Exception {
       //model.addAttribute("movie",movieRepository.deleteById(id));
        movieRepository.deleteById(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieNotFoundException.class)
    public String movieNotFound() {
        return "404";
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(EntityExistsException.class)
    public String movieExists() {
        return "409";
    }
}
