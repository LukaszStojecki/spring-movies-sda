package com.sda.movies.repo;

import com.sda.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);

    List<Movie> findAll();
}
