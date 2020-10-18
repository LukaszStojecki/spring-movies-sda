package com.sda.movies.service;

import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieRepositoryImpl {

    @Autowired
    private MovieRepository movieRepository;

    public MovieRepositoryImpl() {
    }

    public Movie addMovie(Movie movie) throws MovieAlreadyExist {
        Optional<Movie> optionalMovieFromDB = movieRepository.findByTitle(movie.getTitle());
        if (optionalMovieFromDB.isPresent()) {
            throw new MovieAlreadyExist("Movie already exist");
        } else {
            movieRepository.save(movie);
            return movie;
        }
    }

    public Movie getMovie(Integer id) throws MovieNotFoundException {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()){
            return movie.get();
        } else{
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    public int deleteMovie(Integer id) throws MovieNotFoundException {
        Optional<Movie> optionalMovieFromDB = movieRepository.findById(id);
        if (optionalMovieFromDB.isPresent()) {
            movieRepository.deleteById(id);
            return 1;
        } else {
            throw new MovieNotFoundException("Movie Not Found");
        }

    }

    public int updateMovie(Integer id, String title) throws MovieNotFoundException {
        Optional<Movie> optionalMovieFromDB = movieRepository.findById(id);

        if (optionalMovieFromDB.isPresent()){
            optionalMovieFromDB.get().setTitle(title);
            movieRepository.save(optionalMovieFromDB.get());
            return 1;
        } else{
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

}