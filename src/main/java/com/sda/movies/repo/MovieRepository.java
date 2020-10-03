package com.sda.movies.repo;

import com.sda.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    List<Movie> movies = new ArrayList<>();

    public void addMovieByTitle(String title) {
        Movie movie = new Movie(title, 1);
        System.out.println(movie);
        movies.add(movie);
    }
}
