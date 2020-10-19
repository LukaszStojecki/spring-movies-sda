package com.sda.movies.repo;

import com.sda.movies.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface IAcotorRepository extends PagingAndSortingRepository<Actor,Long> {

        boolean existsByNameAndSurname(String name, String surname);
}
