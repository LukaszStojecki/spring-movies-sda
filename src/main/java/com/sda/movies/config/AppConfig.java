package com.sda.movies.config;

import com.sda.movies.exception.EntityAlreadyExist;
import com.sda.movies.service.MovieRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class AppConfig {

    @Bean
    public MovieRepositoryImpl getMovieRepository() throws EntityAlreadyExist {
        MovieRepositoryImpl movieRepositoryImpl = new MovieRepositoryImpl();
        return movieRepositoryImpl;
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
