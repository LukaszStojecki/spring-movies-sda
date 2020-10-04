package com.sda.movies.config;

import com.sda.movies.exception.MovieAlreadyExist;
import com.sda.movies.model.Movie;
import com.sda.movies.repo.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class AppConfig {

    @Bean
    public MovieRepository getMovieRepository() throws MovieAlreadyExist {
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.addMovie(new Movie("Test"));
        return movieRepository;
    }

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }


}
