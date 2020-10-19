package com.sda.movies.repo;

import com.sda.movies.model.Ticket;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static com.sda.movies.model.Ticket.FIELD_MINIMAL_AGE;
import static com.sda.movies.model.Ticket.FIELD_PRICE;

public interface ITicketRepository extends JpaRepository<Ticket,Long>, JpaSpecificationExecutor {

    static Specification<Ticket> minimalAgeIsAbove(Integer age) {
        return new Specification<Ticket>() {
            @Override
            public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(FIELD_MINIMAL_AGE),age);
            }
        };
    }

    static Specification<Ticket> minimalAgeIsUnder(Integer age) {
        return new Specification<Ticket>() {
            @Override
            public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(FIELD_MINIMAL_AGE),age);
            }
        };
    }

    static Specification<Ticket> priceIsUnder(Integer price) {
        return new Specification<Ticket>() {
            @Override
            public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(FIELD_PRICE), price);
            }
        };
    }


}
