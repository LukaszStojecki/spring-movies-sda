package com.sda.movies.controller;


import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.DAO;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MovieController {

    private DAO dao;

    @Autowired
    public MovieController(DAO dao) {
        this.dao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movies")
    public String createMovie(Movie movie, Model model) throws MovieAlreadyExist{
            Movie newMovie = new Movie();
            newMovie.setTitle(movie.getTitle());
            model.addAttribute("added", dao.addMovie(newMovie));
            return "added";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable("id") Integer id, Model model) throws MovieNotFoundException {
        model.addAttribute("movie", dao.getMovie(id));
        return "movie";

    }

    @GetMapping("/movies")
    public String getAllMovies(Model model){
        model.addAttribute("movies", dao.getAllMovies());
        return "movies";
    }

    @PutMapping("/movies/{id}")
    public String updateMovie(@PathVariable("id") Integer id, @RequestParam(value = "title") String title, Model model) throws MovieNotFoundException {
        model.addAttribute("update", dao.updateMovie(id, title));
        return "update";
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable("id") Integer id, Model model) throws MovieNotFoundException {
        model.addAttribute("delete", dao.deleteMovie(id));
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
