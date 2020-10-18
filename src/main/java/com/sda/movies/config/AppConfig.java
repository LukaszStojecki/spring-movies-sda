package com.sda.movies.config;

import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.service.MovieRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class AppConfig {

    @Bean
    public MovieRepositoryImpl getMovieRepository() throws MovieAlreadyExist {
        MovieRepositoryImpl movieRepositoryImpl = new MovieRepositoryImpl();
        return movieRepositoryImpl;
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
