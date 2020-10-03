package com.sda.movies.repo;

import com.sda.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();
    private static Integer currentId = 1;

    public void addMovie(Movie movie) {
        movie.setId(currentId);
        currentId++;
        System.out.println(movie);
        movies.add(movie);
    }

    public Movie getMovie(Integer id) throws Exception {
        Optional<Movie> movie = movies.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst();

        if (movie.isPresent()){
            return movie.get();
        } else{
            throw new Exception(
                    "movie doest exist"
            );
        }
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}
