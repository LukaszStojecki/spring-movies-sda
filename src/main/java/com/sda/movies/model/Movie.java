package com.sda.movies.model;

public class Movie {

    private Integer id;
    private String title;

    private static Integer currentId = 0;

    public Movie(String title) {
        this.id = currentId++;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
