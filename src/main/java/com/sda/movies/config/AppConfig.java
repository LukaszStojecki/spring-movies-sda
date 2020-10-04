package com.sda.movies.config;

import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.DAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class AppConfig {

    @Bean
    public DAO getMovieRepository() throws MovieAlreadyExist {
        DAO dao = new DAO();
        return dao;
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
