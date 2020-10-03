package com.sda.movies.config;

import com.sda.movies.repo.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MovieRepository getMovieRepository() {
        MovieRepository movieRepository = new MovieRepository();
        return movieRepository;
    }


}
