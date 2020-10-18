package com.sda.movies.service;

import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findMovies(){
        return this.movieRepository.findAll();
    }


    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
