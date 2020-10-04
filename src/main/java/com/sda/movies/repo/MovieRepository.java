package com.sda.movies.repo;

import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.exception.MovieNotFoundException;
import com.sda.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();
    private static Integer currentId = 1;

    public Long addMovie(Movie movie) throws MovieAlreadyExist {
        Long counter = movies.stream()
                .filter(el -> el.getTitle()
                        .equals(movie.getTitle())).count();
        if (counter > 0) {
            throw new MovieAlreadyExist("Movie already exist");
        } else {
            movie.setId(currentId);
            currentId++;
            System.out.println(movie);
            movies.add(movie);
            return counter;
        }
    }

    public Movie getMovie(Integer id) throws MovieNotFoundException {
        Optional<Movie> movie = movies.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst();

        if (movie.isPresent()){
            return movie.get();
        } else{
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public int deleteMovie(Integer id) throws MovieNotFoundException {

        Optional<Movie> movie = movies.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst();

        if (movie.isPresent()){
            movies.remove(movie.get());
            return 1;
       }
        else{
            throw new MovieNotFoundException("Movie Not Found");
        }

    }

    public int updateMovie(Integer id, String title) throws MovieNotFoundException {

        Optional<Movie> movie = movies.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst();

        if (movie.isPresent()){
            movie.get().setTitle(title);
            return 1;
        } else{
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

}
