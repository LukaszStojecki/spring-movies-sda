package com.sda.movies.repo;

import com.sda.movies.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {

    List<Actor> findAll();

    boolean existsByNameAndSurname(String name, String surname);

}
