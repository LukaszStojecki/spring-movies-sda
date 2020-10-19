package com.sda.movies.repo;

import com.sda.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends PagingAndSortingRepository<Movie,Integer> {

    Optional<Movie> findByTitle(String title);
    List<Movie> findAll();


}
