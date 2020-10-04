package com.sda.movies.repo;

import com.sda.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);
}
