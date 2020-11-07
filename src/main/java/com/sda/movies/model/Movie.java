package com.sda.movies.model;


import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "director_id", insertable = false, updatable = false)
    private Director director;

    public Movie(){
    }

    public Movie(String title, Integer id) {
        this.id = id;
        this.title = title;
    }

    public Movie(String title) {
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
