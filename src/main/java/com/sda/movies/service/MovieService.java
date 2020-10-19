package com.sda.movies.service;


import com.sda.movies.model.Movie;
import com.sda.movies.repo.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    public List<Movie> findMovies() {
//        return this.movieRepository.findAll();
//    }
    public Page<Movie> findMovies(Integer page, Integer limit) {
        return this.movieRepository.findAll(PageRequest.of(page,limit));
    }

    public void deleteById(Integer id) {
        this.movieRepository.deleteById(id);
    }

    public Movie addMovie(Movie movie){
        return this.movieRepository.save(movie);
    }


}
