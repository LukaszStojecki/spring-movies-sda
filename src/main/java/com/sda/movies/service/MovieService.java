package com.sda.movies.service;

import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Movie> findMovies(Integer page, Integer limit) {
        return movieRepository.findAll(PageRequest.of(page, limit));
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }


}
