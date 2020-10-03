package com.sda.movies.repo;

import com.sda.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();
    private static Integer currentId = 1;

    public void addMovie(Movie movie) {
        movie.setId(currentId);
        currentId++;
        System.out.println(movie);
        movies.add(movie);
    }
}
